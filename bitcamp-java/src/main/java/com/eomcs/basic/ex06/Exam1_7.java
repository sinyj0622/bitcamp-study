package com.eomcs.basic.ex06;

import java.util.Scanner;

//# 흐름 제어문 - 조건문 if
//
public class Exam1_7 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    System.out.print("입력?");
    int line = keyScan.nextInt();
    

    int a = 0;
    while (a < line) {
      System.out.println("*");
      a++;
      }

    
 
    
  }
}