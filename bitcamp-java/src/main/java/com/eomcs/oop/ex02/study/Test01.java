package com.eomcs.oop.ex02.study;

public class Test01 {
  public static void main(String[] args) {

    Score s = new Score(); //데이터타입일 경우 메서드는 operator이다
    
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 90;
    s.math = 80;
    
    Score s2 = new Score();
    
    s2.name = "홍길동";
    s2.kor = 100;
    s2.eng = 90;
    s2.math = 80;
    
   s.calculate(); //메서드 = operator = 연산자
   // i++  피연산자, 연산자 순서
   
   s2.calculate();
   
   
   System.out.println(s.sum);
   System.out.println(s.aver);
   

  }
}
