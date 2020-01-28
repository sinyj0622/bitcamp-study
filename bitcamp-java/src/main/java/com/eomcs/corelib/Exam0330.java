// 람다(lambda) 문법
package com.eomcs.corelib;

public class Exam0330 {

  static interface Calculator {
    int compute(int start, int end);
  }

  static void test(Calculator c) {
    System.out.printf("결과: %d\n", c.compute(1, 10));
  }

  public static void main(String[] args) {

    // 실행내용이 여러줄인경우 {} 제거 불가
    test((a, b) -> {
      int sum = 0;
      for (int i = 0; i <= b; i++) {
        sum += i;
      }
      return sum;
    });

  }
}


