package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    // 게시글 데이터를 저장할 메모리를 설계
   
    

    
    int count = 0;


    for (int i = 0; i < 100; i++) {
    	count++;
      
      //사용자가 입력한 게시물 데이터를 저장할 메모리를 board 설계도에 따라 만든다.
      
      
      
      System.out.println();

      System.out.print("계속 입력하시겠습니까?(Y/N) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }



    keyboard.close();

    System.out.println();


   


    }
  }
}


