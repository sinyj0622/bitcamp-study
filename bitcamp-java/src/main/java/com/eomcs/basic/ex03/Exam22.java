package com.eomcs.basic.ex03;

//공개클래스는 다른 개발자가 사용가능
//정수 리터럴 - _ (언더바사용법)

public class Exam22 {
  public static void main(String[] args) {
    //데이터는 크게 아래 5개이다

    /*정수 리터럴
    10진수 표시법*/
    System.out.println(2_3500_0000);
    System.out.println(235_000_000); 
    //언더바는 위치를 마음대로 해도된다(앞뒤제외)
    //System.out.println(_235_000_000) 안됨
    //System.out.println(235_000_000_)

    //8진수 리터럴
    System.out.println(01_44);
    System.out.println(0_144);
    //System.out.println(0144_);
    //System.out.println(_0144);
    
    //2진수 - 0B로 시작
    System.out.println(0b01100100);
    System.out.println(0B01100100);
    //System.out.println(0b01100100_);
    //System.out.println(0b_01100100);
    //System.out.println(_0b01100100);



    //16진수 - Ox로 시작
    System.out.println(0x00_64); //0을 넣어도 상관없다
    //System.out.println(0X_0064); //실무에서는 소문자를 쓴다
    //System.out.println(0X0064_);
    //System.out.println(_0X0064);

  }
}