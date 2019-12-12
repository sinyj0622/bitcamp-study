package com.bitcamp.myproject;

import java.sql.Date;
import java.util.Scanner;

public class App{
    public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      
        
        System.out.print("어디로 떠나세요?: ");
        String travelDestnation = keyboard.nextLine();
       
        System.out.print("여행 제목? ");
        String travelTitle = keyboard.nextLine();
        
        System.out.print("여행 인원? ");
        int person = keyboard.nextInt();
        
        System.out.print("여행 시작일? ");
        Date startDate = Date.valueOf(keyboard.next());
        
        System.out.print("여행 종료일? ");
        Date endDate = Date.valueOf(keyboard.next());
        
        System.out.print("예상 경비? ");
        int travelMoney = keyboard.nextInt();
           
        System.out.println();
        
        System.out.printf("어디로 떠나세요?: %s\n", travelDestnation);
        System.out.printf("여행 제목? %s\n", travelTitle);
        System.out.printf("여행 인원? %s명\n", person);
        System.out.printf("여행 시작일? %s\n", startDate);
        System.out.printf("여행 종료일? %s\n", endDate);
        System.out.printf("예상  경비? %s원\n", travelMoney);
        
        
      keyboard.close();
        
        
    }
}
