package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    
    class Member {
      int no;
      String name;
      String email;
      String password;
      String photo;
      String tel;
      Date registeredDate;
    }

    final int SIZE = 100; //상수는 대문자
    
    Member[] members = new Member[SIZE];

    for (int i =0; i < SIZE; i++) {
      //회원정보를 저장할 메모리를 Member 설계도에 담는다
      Member member  = new Member();
    }
    

    int count = 0; //몇명입력했는지 알기위해
    for(int i = 0; i < SIZE; i++) {
      Member member = members[i];
      
      count++;
      
      System.out.print("번호?: ");
      member.no = keyboard.nextInt();
      keyboard.nextLine();
   
      System.out.print("이름?: ");
      member.name = keyboard.nextLine();

      System.out.print("이메일?: ");
      member.email = keyboard.nextLine();

      System.out.print("암호?: ");
      member.password = keyboard.nextLine();

      System.out.print("사진?: ");
      member.photo = keyboard.nextLine();

      System.out.print("전화?: ");
      member.tel = keyboard.nextLine();

      member.registeredDate = new Date(System.currentTimeMillis());

      //회원정보가 담겨있는 인스턴스의 주소를 레퍼런스 배열에 보관한다
      members[i] = member;
 
      
      System.out.print("계속 입력하시겠습니까?(Y / N) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) 
        break;
      }

    
    keyboard.close();
    
    System.out.println();
    
    for (int i = 0; i < count; i++) {  //입력받은 명수만 출력 count
      Member member = members[i];
    System.out.printf("%d, %s, %s,  %s, %s\n", 
        member.no, member.name, member.email, member.tel, member.registeredDate);
    }

  }
}
