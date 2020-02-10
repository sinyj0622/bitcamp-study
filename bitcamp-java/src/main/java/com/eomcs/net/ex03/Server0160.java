// 클라이언트와 입출력 테스트 - byte Stream + buffer
package com.eomcs.net.ex03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0160 {
  public static void main(String[] args) {

    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("클라이언트의 연결을 기다리고 있음.");

      try (Socket socket = serverSocket.accept();
          Scanner in = new Scanner(new BufferedInputStream(socket.getInputStream()));
          PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()))) {

        System.out.println("클라이언트와 통신할 입출력 스트림이 준비되었음.");

        System.out.println("클라이언트가 보낸 한줄의 문자열을 기다리고 있음!");
        // => 클라이언트가 1바이트를 때까지 리턴하지 않는다.
        String str = in.nextLine();
        System.out.println(str);

        System.out.print(">");
        keyboard.nextLine();

        out.println(str);
        // out.flush();
        // byte Stream 에서 버퍼를 사용할 때는
        // 데이터를 보내기 위해 반드시 flush()를 호출해야 한다.
        System.out.println("클라인트에게 데이터를 보냈음.");

      }
      System.out.println("클라이언트와의 연결을 끊었음.");

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }

}

