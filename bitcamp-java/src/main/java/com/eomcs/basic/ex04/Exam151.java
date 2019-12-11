package com.eomcs.basic.ex04;

public class Exam151 {
  public static void main(String[] args){

    // 변수 사용
    int i;
    i = 100;

    System.out.println(i); 
    
    int j;
    j = i; //i의 변수에 들어있는 값!을 j변수에 넣어라

    //할당연산자 '=' 
    //-변수에 값을 넣는 일을 한다
    //- 문법
    // l-value = r-value 
    //l-value :변수가 와야 한다. 값이 올 수 없다.
    //r-value :값이나 변수, 표현식이 올수있다


    j = 300; //값
    j = i; //변수
    j = i * 3; //표현식 ,값이 놓임
    j = Math.abs(-200); //표현식 ,값이 놓임
    j = (i > 100) ? 1 : -1; //표현식 ,값이 놓임
    //j = syste.out.println(100); //그냥 문장이다 표현식이 아니다


    //문장(statement)
    // 자바 언어로 작성한 명령어

    //표현식(expression)
    // 문장중에 값을 리턴하는 문장



  }
}