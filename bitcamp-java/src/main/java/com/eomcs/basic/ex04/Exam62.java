package com.eomcs.basic.ex04;


// 상수
public class Exam62 {
  public static void main(String[] args){
   

    int a = 100;
    
    a = 100;
    a = 200;
    
    
    // 한번 저장된 값을 변경하지 못하게 하는 문법 final
    final int b;
    b = 100;
    //b = 200; //컴파일오류
    
    final int c = 100;
    //c = 200; //컴파일오류, 배열의 사이즈로 final



  }
}