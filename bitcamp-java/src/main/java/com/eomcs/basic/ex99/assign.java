package com.eomcs.basic.ex99;

import java.util.Scanner;

public class assign {
  public static void main(String[] args){
// 과제 1 : 계산기 애플리케이션을 작성하라.
// - 실행
// 값1? 10
// 값2? 20
// 연산자(+,-,*,/)? +
// => 10 + 20 = 30 

Scanner keyboard = new Scanner(System.in);


int i, j;
String response;

System.out.print("값1? ");
i = keyboard.nextInt();

System.out.print("값2? ");
j = keyboard.nextInt();
keyboard.nextLine();

System.out.print("연산자(+,-,*,/)? ");
response = keyboard.nextLine();


int result = 0;
if (response.equals("+")){
  result = i + j;
} else if (response.equals("-")){
    result = i - j;
  } else if (response.equals("*")){
      result = i * j;
    } else if (response.equals("/")){
        result = i / j;}


        System.out.printf("=> %d %s %d = %d ", i, response, j, result);
keyboard.close();



  }
}