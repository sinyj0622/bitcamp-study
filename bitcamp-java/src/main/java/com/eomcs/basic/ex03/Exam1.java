package com.eomcs.basic.ex03;

//literal
public class Exam1 {
  public static void main(String[] args) {
    //데이터는 크게 아래 5개이다

    //정수 리터럴
    System.out.println(78); //10진수 표시법
    
    System.out.println(+78);
    System.out.println(-78);

    System.out.println(0116); //8진수 표시법 (0으로 시작하면 8진수다)
    System.out.println(-0116); //8진수 표시법 >10진수로 나타난다

    System.out.println(0x4e); //16진수 표시법
    System.out.println(-0x4e); //16진수 표시법

    System.out.println(0b01001110); //8진수 표시법

    //부동소수점 리터럴
    System.out.println(3.14); //고정소수점
    System.out.println(0.314e1); //부동소수점 e1에 10의1승을 곱해라 0.314*10
    System.out.println(31.4e-1); //부동소수점 값은 같다

    //논리 리터럴
    System.out.println(true); //참
    System.out.println(false); //거짓 java는 대소문자를 구분한다

    //문자 리터럴
    System.out.println('a'); //문자 한개를 표현할때 싱글''
    System.out.println('가');

    //문자열 리터럴
    System.out.println("안녕하세요! 비트캠프!");


  }
}