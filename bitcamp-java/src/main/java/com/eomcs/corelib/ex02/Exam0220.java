// Wrapper 클래스 - auto-boxing/auto-unboxing
package com.eomcs.corelib.ex02;

public class Exam0220 {
  public static void main(String[] args) {
    // int ==> Integer
    int i1 = 100;
    Integer obj1 = Integer.valueOf(i1);

    // Integer ==> int
    Integer obj2 = Integer.valueOf(200);
    int i2 = obj2.intValue();


    // Integer 객체생성
    int i3 = 200;
    Integer obj3 = Integer.valueOf(i3);

    // 객체 값을 꺼낼때
    Integer obj4 = Integer.valueOf(300);
    int i4 = obj4.intValue();
    System.out.println(i4);
  }
}


