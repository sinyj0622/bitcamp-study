
package com.eomcs.basic.ex05;

import java.util.Scanner; //자바.유팉에 있는 스캐너라고 알려줌

public class test01 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in); //system.in 키보드 값을 스캔한다
    //레퍼런스는 리모컨  = 새로운 도구(도구 사용에 필요한것)
    // 입력? 3, 7
    // 3에서 7까지의 합은  입니다

    System.out.print("입력? ");
    int start = keyboard.nextInt(); //스캐너로 읽은값을 (int단위로 짤라줘(기능)) 그리고 a에 담아줘
    int end = keyboard.nextInt();

    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum = sum + i;
    }

    System.out.printf("%d에서 %d까지의 합은 %d입니다.\n", start, end, sum);
    keyboard.close(); // 레퍼런스의.기능


  }
}