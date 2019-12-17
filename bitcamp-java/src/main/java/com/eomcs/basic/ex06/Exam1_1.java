package com.eomcs.basic.ex06;

//# 흐름 제어문 - 조건문 if
//
public class Exam1_1 {
  public static void main(String[] args) {
    int age = 17;

    // => if (조건) 문장;
    if (age >= 19) System.out.println("성인이다.");

    // => 문장을 다른 줄에 놓는 경우가 많다.
    if (age >= 19); // if 문에 빈 문장을 넣을 수 있다.(;세미콜론 있는경우 끝 다른문장으로 생각함)
    System.out.println("성인이다.");
    // 이런 경우 개발자가 오해할 수 있다. 
    // if (조건) 뒤에 문자의 끝을 표시하는 세미콜론을 사용하지 않도록 조심하라!

    //참고!
    // 연산자,피연산자,문장기호에 따라 여러줄에 걸쳐 작성할수 있지만 읽기 쉽게 작성하라!!
    // 다음과 같이 하지말라
    if (age 
        >= 
        19) System
    .
    out.
    println(
        "성인이다.")
    ;
  }
}