// final 사용법: 오버라이딩 불가
package com.eomcs.oop.ex06.e;

public class Exam0140 extends Exam0130 {
  @Override
  public void m1() {
    // final 메서드는 오버라이딩 불가!!!!!!!!!!!!!!
  }

  @Override
  public void m2() {
    // final이 아닌 메서드는 오버라이딩 가능!!!!!!!!!!!!!
  }
}
