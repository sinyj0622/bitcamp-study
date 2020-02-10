// 서버와 입출력 테스트 - character Stream
package com.eomcs.net.ex03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client0210 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    try (Socket socket = new Socket("localhost", 8888);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      System.out.println("서버와 연결되었음!");

      // 서버에 데이터를 보내기전에 잠깐 멈춤
      System.out.print(">");
      keyScan.nextLine();

      out.println("ABC 가각간");
      // out.flush();
      // character Stream 클래스의 경우
      // 출력 데이터를 내부 버퍼에 보관하고 있다가
      // flush()가 호출되면 비로서 출력을 수행한다.
      // 따라서 위 출력 문자열은 서버에 보내지 않는다

      // byte Stream 을 사용할 때는 바로 출력한다.
      // 따라서 flush()를 호출하지 않아도된다
      System.out.println("서버에 데이터를 보냈음!");

      // 서버의 응답을 받는다.
      // - 서버가 응답을 할 때까지 리턴하지 않는다.
      // 즉 blocking 모드로 작동한다.
      String str = in.readLine();
      System.out.println(str);

    } catch (Exception e) {
      e.printStackTrace();
    }
    keyScan.close();
  }
}


