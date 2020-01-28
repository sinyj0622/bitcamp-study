// 람다(lambda) 문법
package com.eomcs.oop.ex12;

public class Exam0240 {

  static abstract class Player {
    public abstract void play();
  }

  public static void main(String[] args) {
    Player p1 = () -> System.out.println("Hello"); // 추상 클래스 컴파일오류!
    p1.play();
  }
}


