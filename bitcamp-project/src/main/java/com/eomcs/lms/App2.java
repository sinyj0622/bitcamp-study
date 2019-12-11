package com.eomcs.lms;

import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("번호?: ");
    String no = keyboard.nextLine();
    
    System.out.print("이름?: ");
    String name = keyboard.nextLine();
    
    System.out.print("이메일?: ");
    String email = keyboard.nextLine();
    
    System.out.print("암호?: ");
    String password = keyboard.nextLine();
    
    System.out.print("사진?: ");
    String photo = keyboard.nextLine();
    
    System.out.print("전화?: ");
    String phone = keyboard.nextLine();
    
    System.out.print("가입일?: ");
    String siginDate = keyboard.nextLine();
    
   
    System.out.println();
        
    System.out.println("번호: " + no );
    System.out.println("이름: " + name );
    System.out.println("이메일: " + email );
    System.out.println("암호: " + password );
    System.out.println("사진: " + photo );
    System.out.println("전화: " + phone );
    System.out.println("가입일: " + siginDate);
    
    keyboard.close();
    
    
  }
}
