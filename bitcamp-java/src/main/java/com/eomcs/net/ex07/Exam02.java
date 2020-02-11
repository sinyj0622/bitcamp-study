// URL(Uniform Resource Locator) - 포트번호 생략
package com.eomcs.net.ex07;

import java.net.URL;

public class Exam02 {

  public static void main(String[] args) throws Exception {
    // 웹 상에서 자원의 위치를 표현하는 방법
    // => [프로토콜]://서버주소:포트번호/자원의경로
    //
    // - 프로토콜 : http, httpsm ftp 등
    // - 서버주소 : IP 주소(192.168.0.1), 도메인명(www.bitcamp.co.kr)
    // - 포트번호 : 80(생략가능), 8080(프록시 서버) 등
    // - 자원의 경로:/index.html, /board/list.jsp 등
    //
    URL url = new URL("http://bitcamp.co.kr/index.php");

    // URL 분석
    System.out.printf("프로토콜: %s\n", url.getProtocol());
    System.out.printf("서버주소: %s\n", url.getHost());
    System.out.printf("포트번호: %d\n", url.getPort()); // 생략하면 -1 리턴
    // 웹브라우저에서는 포트번호를 생략하면 80번으로 간주한다.
    System.out.printf("자원경로: %s\n", url.getPath());
    System.out.printf("QueryString: %s\n", url.getQuery());
    // Query String
    // - 자원의 경로(예: /index.php) 다음(물음표? 다음)에 오는 파라미터
    // - 형식: 파라미터명=값&파라미터명=값&파라미터명=값
    // 예)where=nexearch&query=28번째%20확진자&sm=top_lve.agallgrpmamsi0en0sp0&ie=utf8

  }

}


