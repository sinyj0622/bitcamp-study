
package com.eomcs.basic.ex05;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
// 입력? 3, 7
// 3에서 7까지의 합은  입니다

      System.out.print("입력? ");
      int a = keyboard.nextInt();
      System.out.print("입력? ");
      int b = keyboard.nextInt();
      
      int sum = 0;
      for (int i = a; i <= b; i++) {
    	  sum = sum + i;
      }
      
     
      
      System.out.printf("%d에서 %d까지의 합은 %d입니다.", a, b, sum);
      

        

      
      

    }
}