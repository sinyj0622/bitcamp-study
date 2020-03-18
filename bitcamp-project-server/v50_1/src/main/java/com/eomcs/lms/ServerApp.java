// LMS 서버
package com.eomcs.lms;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.sql.SqlSessionFactoryProxy;
import com.eomcs.util.RequestHandler;
import com.eomcs.util.RequestMappingHandlerMapping;

public class ServerApp {

  // 옵저버 관련 코드
  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();

  // 스레드풀 (스레드를 재사용하자!!)
  ExecutorService executorService = Executors.newCachedThreadPool();

  // 서버 멈춤 여부 설정 변수
  boolean serverStop = false;

  // IoC 컨테이너 준비
  ApplicationContext iocContainer;

  // requestHandler 맵퍼 준비
  RequestMappingHandlerMapping handlerMapper;

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }
  // 옵저버 관련코드 끝!

  @SuppressWarnings("unchecked")
  public void service() {

    notifyApplicationInitialized();

    // ApplicationContext(IoC 컨테이너)를 꺼낸다
    iocContainer = (ApplicationContext) context.get("iocContainer");

    // request Hadler Mapper를 꺼낸다
    handlerMapper = (RequestMappingHandlerMapping) context.get("handlerMapper");

    // IoC 컨테이너에서 SqlSessionFactory를 꺼낸다
    SqlSessionFactory sqlSessionFactory =
        (SqlSessionFactory) iocContainer.getBean("sqlSessionFactory");


    try (ServerSocket serverSocket = new ServerSocket(9999)) {

      System.out.println("클라이언트 연결 대기중...");

      while (true) {
        Socket socket = serverSocket.accept(); // 대기열
        System.out.println("클라이언트와 연결되었음!");

        executorService.submit(() -> {
          processRequest(socket);

          // 스레드에 보관된 SqlSession 객체를 제거한다.
          //
          ((SqlSessionFactoryProxy) sqlSessionFactory).closeSession();
          System.out.println("--------------------------------------");
        });

        // 현재 '서버 멈춤' 상태라면
        // 다음 클라이언트 요청을 받지 않고 종료한다.
        if (serverStop) {
          break;
        }

      }

    } catch (Exception e) {
      System.out.println("서버 준비 중 오류 발생!");
    }


    // 스레드풀을 다 사용했으면 종료하라고 해야한다.
    executorService.shutdown();
    // => 스레드풀을 당장 종료시키는 것이 아니다.
    // => 스레드풀의 소속된 스레드들의 작업이 모두 끝나면
    // 스레드풀의 동작을 종료하라는 뜻이다.
    // => 따라서 shutdown()을 호출했다고 해서
    // 모든 스레드가 즉시 작업을 멈추는 것이 아니다.
    // => 즉 스레드풀 종료를 예약한 다음에 바로 리턴한다.

    // 모든 스레드가 끝날 때 까지 DB 커넥션을 종료하고 싶지 않다면,
    // 스레드가 끝났는지 검사하며 기다려야 한다.
    while (true) {
      if (executorService.isTerminated()) {
        break;
      }
      try {
        Thread.sleep(500); // 0.5초 마다 깨어나서 스레드 종료 여부를 검사한다.
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    // 클라이언트 요청을 처리하는 스레드가 모두 종료된 후에
    // DB 커넥션을 닫도록 한다.
    notifyApplicationDestroyed();

    System.out.println("서버 종료!");

  } // service()


  void processRequest(Socket clientSocket) {

    try (Socket socket = clientSocket;
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream())) {

      // 클라이언트가 보낸 명령을 읽는다.
      String request = in.nextLine();
      System.out.printf("=> %s\n", request);

      // 클라이언트에게 응답한다.

      if (request.equalsIgnoreCase("/server/stop")) {
        quit(out);
        return;
      }


      // 클라이언트의 요청을 처리할 객체를 찾는다.
      RequestHandler requestHandler = handlerMapper.getHandler(request);


      if (requestHandler != null) {
        try {
          requestHandler.getMethod().invoke(requestHandler.getBean(), in, out);

        } catch (Exception e) {
          // 요청한 작업을 수행하다가 오류 발생할 경우 그 이유를 간단히 응답한다.
          out.println("요청 처리 중 오류 발생!");
          out.println(e.getMessage());

          // 서버쪽 화면에는 더 자세하게 오류 내용을 출력한다.
          System.out.println("클라이언트 요청 처리 중 오류 발생:");
          e.printStackTrace();
        }

      } else { // 없다면? 간단한 안내 메시지를 응답한다.
        notFound(out);
      }
      out.println("!end!");
      out.flush();
      System.out.println("클라이언트에게 응답하였음!");


    } catch (Exception e) {
      System.out.println("예외 발생:");
      e.printStackTrace();
    }
  }

  private void notFound(PrintStream out) throws IOException {
    out.println("요청한 명령을 처리할 수 없습니다.");
  }

  private void quit(PrintStream out) throws IOException {
    serverStop = true;
    out.println("OK");
    out.println("!end!");
    out.flush();

  }

  public static void main(String[] args) {
    System.out.println("서버 수업 관리 시스템입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new ContextLoaderListener());
    app.service();
  }
}
