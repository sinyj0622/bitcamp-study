package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

//# 흐름 제어문 - for 반복문과 컬렉션
//
public class Exam6 {
  public static void main(String[] args) {
    Scanner keyscan = new Scanner(System.in);

    System.out.print("밑변 길이? ");
    int a = keyscan.nextInt();
    
   int i = 1;
   while (i <= a) {
     int j = 1;
     while (j <= i) {
       System.out.print("*");
       j++;
     }
     System.out.println();
     j++;
   }
    
    


      keyscan.close();
    }
  }

