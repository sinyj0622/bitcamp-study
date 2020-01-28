// 람다(lambda) 문법
package com.eomcs.oop.ex12;

public class Exam0310 {

  static interface Player {
    void play();
  }

  static void testPlayer(Player p) {
    p.play();
  }

  public static void main(String[] args) {
    // 로컬 클래스

    class MyPlayer implements Player {
      @Override
      public void play() {
        System.out.println("안녕~~~");

      }
    }
    testPlayer(new MyPlayer()); // 메소드 하나짜리 인터페이스 주소를 넘길때
  }
}


