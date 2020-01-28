// 람다(lambda) 문법
package com.eomcs.oop.ex12;

public class Exam0410x {

  static interface Interest {
    double compute(int money);
  }

  static Interest getInterest(final double rate) {
    // 로컬 클래스에서 로컬 변수를 사용할때
    // Interest 인터페이스를 구현한 객체를 생성해서 넘긴다

    return (money) -> money + (money * rate / 100);



  }

  public static void main(String[] args) {

    Interest i1 = getInterest(1.5);
    System.out.printf("합계: %.1f\n", i1.compute(10_0000_0000));

    Interest i2 = getInterest(2.5);
    System.out.printf("합계: %.1f\n", i2.compute(10_0000_0000));


  }
}


