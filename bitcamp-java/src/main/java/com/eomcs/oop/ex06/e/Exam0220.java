// final 사용법: 로컬 변수
package com.eomcs.oop.ex06.e;


public final class Exam0220 {

  public void m1() {
    // 로컬 변수에 final을 붙이면 값을 변경할 수 없는 상수로 사용된다.
    
    final int a = 100;
    // final 로컬 변수는 값을 변경 할수 없다
    // a = 200; //컴파일오류
      
    // 변수를 선언할 때 값을 초기화 시키지 않고
    // 다음에 초기화 시킬수있다
    
    final int b;
    b = 100;
    
    // b = 200; //컴파일 오류!
  }
}
