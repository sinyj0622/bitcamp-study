
package com.eomcs.basic.ex05;

import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
// 입력? 7 4 12 8 9
// 최소값?
// 최대값?
      int[] arr = new int[5];
      int max = 0;
      int min = 0;
      System.out.print("입력? ");
      for (int i = 0; i < 5; i++) { 
        arr[i] = keyboard.nextInt();
        if ( arr[i] > max ) { max = arr[i]; }
        else  { min = arr[i]; }
         
        }
      
    

         
      System.out.println("최대값: " + max);     
      System.out.println("최소값: " + min);     



    }
}