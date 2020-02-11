// HTTP 클라이언트 만들기
package com.eomcs.net.ex06;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// HTTP 요청 프로토콜
// ---------------------------------
// GET [자원주소] HTTP/1.1 (CRLF) < request라인
// Host: [서버주소] (CRLF) < header
// (CRLF) < 줄바꿈코드
// ---------------------------------
//
// 프로토콜(protocol)?
// => 클라이언트/서버 간의 통신 규칙.
// => 데이터를 주고 받는 규칙.
//
public class HttpClient {
  public static void main(String[] args) throws Exception {
    Socket socket = new Socket("coffeecg.com", 80);

    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    // HTTP 요청 프로토콜에 따라 서버에 데이터 전송
    // => macOS에서 JVM을 실행할 때,
    // println()은 문자열 뒤에 0a(LF) 코드만 붙인다.
    // 따라서 macOS 에서 실행할 때는 다음과 같이 명확하게 CRLF 코드를 붙인다
    //
    out.println("GET / HTTP/1.1");
    out.println("Host: coffeecg.com");
    out.println();

    // HTTP 응답 프로토콜에 따라 서버가 보낸 데이터를 수신
    while (true) {
      try {
        System.out.println(in.nextLine());
      } catch (Exception e) {
        break;
      }
    }

    out.close();
    in.close();
    socket.close();
  }
}


