package com.bitcamp.myproject;

import java.util.Scanner;

public class App4 {
  public static void main(String[] args) {
    Scanner keyscan = new Scanner(System.in);

    System.out.println("지원부서");
    System.out.println("1. S/W개발");
    System.out.println("2. 일반관리");
    System.out.println("3. 시설경비");
    System.out.println("지원 분야의 번호를 입력하세요? ");
    int no = keyscan.nextInt();

    System.out.println("제출하실 서류는 다음과 같습니다.");
    if (no == 1) {
      System.out.println("정보처리자격증");
      System.out.println("졸업증명서");
      System.out.println("이력서");
    } else if (no == 2) {
      System.out.println("졸업증명서");
      System.out.println("이력서");
    } else if (no == 3) {
      System.out.println("이력서");
    } else  {
      System.out.println("올바른 번호를 입력하세요!");
    }
    
 
  }

}



