package com.eomcs.basic.ex03;

// 이스케이프 문자(escape character)
public class Exam7 {
  public static void main(String[] args) {
    // 이스케이프 문자
    // - 문자를 제어하는 기능을 가진 문자
    // - 문법
    //   \ [ n | r | f | t | b | ' | " | \ ]
    System.out.println("Hello,World!");
    System.out.println("Hello,\nWorld!"); // new line - 줄바꿈 명령문자
    System.out.println("Hello,\rabc"); // return - 커서(cursor)를 처음으로 돌리는 문자
    // 커서란? 문자를 출력할 위치를 가리키는것.

    System.out.println("Hello,\b\b\bWorld"); // back - 커서를 뒤로 한칸 이동시키는 문자
    System.out.println("Hello,\tWorld"); // tab 탭공간을 추가시키는 문자
    System.out.println("Hello,\fWorld"); // form feed 추가시키는 문자
    System.out.println("Hello,\"W\"orld"); // " 문자를 추가시키는 문자 ""      \"\"
    System.out.println("Hello,'W'orld"); // ""안에서 '' 문자를 그냥 적는다.
    System.out.println('\''); // '' 안에서 ' 문자를 출력시키는 문자
    System.out.println('"'); // '' 안에서 " 문자는 그냥 적는다
    System.out.println("c:\\Users\\user\\git");  // \ 문자를 출력시키는 문자 파일경로 표시할때

    // 줄바꿈 코드
    // Carrage return(CR) : 0d
    // Line feed(LF) : 0a
    //
    // - window OS 에서는 줄바꿈을 표시하기 위해 
    // CRLF 2바이트 코드를 삽입한다.
    // - UNIX OX 에서는 줄바꿈을 표시하기 위해
    // LF 1바이트 코드를 삽입한다.







  }
    }