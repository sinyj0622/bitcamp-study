// 서버와 입출력 테스트 - byte Stream
package com.eomcs.net.ex03;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0150 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    try (Socket socket = new Socket("192.168.1.43", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())) {

      System.out.println("서버와 연결되었음!");

      // 서버에 데이터를 보내기전에 잠깐 멈춤
      System.out.print(">");
      keyScan.nextLine();

      out.println("ABC 가각간");
      // out.flush();
      // byte Stream 을 사용할 때는 바로 출력한다.
      // 따라서 flush()를 호출하지 않아도된다
      System.out.println("서버에 데이터를 보냈음!");

      // 서버의 응답을 받는다.
      // - 서버가 응답을 할 때까지 리턴하지 않는다.
      // 즉 blocking 모드로 작동한다.
      String str = in.nextLine();
      System.out.println(str);

    } catch (Exception e) {
      e.printStackTrace();
    }
    keyScan.close();
  }
}


