package com.bitcamp.myproject;

import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("이름: ");
    String no = keyboard.nextLine();
    System.out.print("별명: ");
    String nickname = keyboard.nextLine();
    System.out.print("이메일: ");
    String email = keyboard.nextLine();
    System.out.print("암호: ");
    String passWord = keyboard.nextLine();
    System.out.print("사진: ");
    String myphoto = keyboard.nextLine();
    System.out.print("전화: ");
    String phonenumber = keyboard.nextLine();
    
    
     System.out.println(); 

     System.out.printf("이름: %s\n", no);
     System.out.printf("별명: %s\n", nickname);
     System.out.printf("이메일: %s\n", email );
     System.out.printf("암호: %s\n", passWord);
     System.out.printf("사진: %s\n", myphoto);
     System.out.printf("전화: %s\n", phonenumber);
 
     keyboard.close();
   
    
  }

}
