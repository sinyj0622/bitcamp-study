package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Exam6 {
  public static void main(String[] args) {
    Scanner keyscan = new Scanner(System.in);

    System.out.print("밑변 길이? ");
    int length = keyscan.nextInt();
    
    int a = 1;
     while (a <= length) {
    	 int b = 1;
    	 while (b <= a) {
    		 System.out.print("*");
    		 b++;
    	 }
    	 System.out.println();
    	 a++;
     }
    
     a = length - 1;
     while (a >= 1) {
    	 int b = 1;
    	 while (b <= a) {
    		 System.out.print("*");
    		 b++;
    	 }
    	 System.out.println();
    	 a--;
     }
  

      keyscan.close();
    }
  }

