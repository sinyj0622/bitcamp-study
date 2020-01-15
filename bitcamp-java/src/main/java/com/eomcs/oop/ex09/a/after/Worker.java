// 인터페이스 - caller와 callee 사이의 호출 규칙을 정의하는 문법
package com.eomcs.oop.ex09.a.after;


// caller(호출자:사용자) : exam01
// callee(피호출자:도구)  : BlueWorker, WhiteWorker, JubuWorker
// 문법:
//    interface 사용규칙명 {...}
public interface Worker {
    
    // 호출 규칙?
    // => 메서드 형식을 의미한다.
    // => 메서드의 몸체는 정의하지 않는다.
    // => 메서드의 몸체는 이 규칙에 따라 만드는 클래스에서 정의하는 것이다.
  
  // 문법
  // =>  public abstract 리턴타입 메서드명(파라미터)
  // => public abstract 는 모두 생략가능
  // => public 외에 다른 접근 범위 사용불가~!!!!!!!!!(규칙은 공개되어야한다!!!!!!!!!!!!!!)
    void execute();
}
