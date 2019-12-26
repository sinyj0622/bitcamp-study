package com.eomcs.basic.ex07.assignment;

import java.util.Scanner;

// 과제: 재귀호출을 이용하여 직삼각형을 출력하라.
// 실행)
// 밑변의 길이? 5
// *
// **
// ***
// ****
// *****
//
public class Test05 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    // 사용자로부터 밑변의 길이를 입력 받는다.
    System.out.print("밑변의 길이? ");
    int base = keyboard.nextInt();
    keyboard.close();

    // 직삼각형을 출력한다.
    printTriangle(base);
  }

  static void printTriangle(int base) {
    // 코드를 완성하시오!
    if (base == 0)
      return;

    printTriangle(base - 1); //재귀함수 끝까지 반복후 아래함수에서 하나씩 값이0리턴됨

    for (int i = 0; i < base; i++) {
      System.out.print("*");
    }

    System.out.println();

  }
}




