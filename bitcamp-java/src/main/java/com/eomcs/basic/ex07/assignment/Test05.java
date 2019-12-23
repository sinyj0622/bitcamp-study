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
  static Scanner keyboard = new Scanner(System.in);
  static int response;
  
  public static void main(String[] args) {
    // 사용자로부터 밑변의 길이를 입력 받는다.
    int base = 0;
    System.out.print("밑변의 길이? ");
    base = keyboard.nextInt();
    
    // 직삼각형을 출력한다.
    printTriangle(base);
  }
  
  static void printTriangle(int base) {
    // 코드를 완성하시오!
    for(int j = 1; j <= base; j++) {
    for (int i = 0; i < j ; i++) {
      System.out.print("*");
    }
    System.out.println();
    }
  }
}





