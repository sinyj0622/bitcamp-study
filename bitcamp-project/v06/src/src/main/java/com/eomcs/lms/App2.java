package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    final int SIZE = 100; //상수는 대문자
    
    int[] no = new int[100];
    String[] name = new String[SIZE];
    String[] email = new String[SIZE];
    String[] password = new String[SIZE];
    String[] photo = new String[SIZE];
    String[] tel = new String[SIZE];
    Date[] registeredDate = new Date[SIZE];


    int count = 0; //몇명입력했는지 알기위해
    for(int i = 0; i < SIZE; i++) {
      count++;
      
      System.out.print("번호?: ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine();
   
      System.out.print("이름?: ");
      name[i] = keyboard.nextLine();

      System.out.print("이메일?: ");
      email[i] = keyboard.nextLine();

      System.out.print("암호?: ");
      password[i] = keyboard.nextLine();

      System.out.print("사진?: ");
      photo[i] = keyboard.nextLine();

      System.out.print("전화?: ");
      tel[i] = keyboard.nextLine();

      registeredDate[i] = new Date(System.currentTimeMillis());

 
      
      System.out.print("계속 입력하시겠습니까?(Y / N) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) 
        break;
      }

    
    keyboard.close();
    
    System.out.println();
    
    for (int i = 0; i < count; i++) {  //입력받은 명수만 출력 count
    System.out.printf("%d, %s, %s,  %s, %s\n", 
        no[i], name[i], email[i], tel[i], registeredDate[i]);
    }

  }
}
