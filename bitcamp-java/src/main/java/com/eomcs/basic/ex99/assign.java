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
int result = 0;

int i, j;
String response;

System.out.print("값1? ");
i = keyboard.nextInt();

System.out.print("값2? ");
j = keyboard.nextInt();
keyboard.nextLine();

System.out.print("연산자(+,-,*,/)? ");
response = keyboard.nextLine();

if (response.equals("+")){
  result = i + j;}
  else if (response.equals("-")){
    result = i - j;}
    else if (response.equals("*")){
      result = i * j;}
      else if (response.equals("/")){
        result = i / j;}




        System.out.println("=>" + i + response + j +"=" + result);
keyboard.close();





  }
}