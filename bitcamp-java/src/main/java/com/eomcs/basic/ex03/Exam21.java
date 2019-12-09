package com.eomcs.basic.ex03;

//공개클래스는 다른 개발자가 사용가능
public class Exam21 {
  public static void main(String[] args) {

    /*정수 리터럴
    10진수 표시법*/
    System.out.println(100);

    //8진수 리터럴
    System.out.println(0144);
    
    //2진수 - 0B로 시작
    System.out.println(0b01100100);
    System.out.println(0B01100100);

    //16진수 - Ox로 시작
    System.out.println(0x064); //0을 넣어도 상관없다
    System.out.println(0X64); //실무에서는 소문자를 쓴다


  }
}