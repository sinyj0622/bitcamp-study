package com.eomcs.basic.ex04;


// 형변환 : 부동소수점 변수 > 정수 변수
public class Exam92 {
  
  
  public static void main(String[] args) {
   
    float f = 3.14f;
    double d = 3.14;
    
    int i;
    long l;
    
    //i = f;//컴파일오류
    //f = l;
    //l = f;
    //l = d;
    
    //부동소수점 값을 정수 변수에 강제로 저장시키려면
    //형변환(type casting)문법을 사용해야한다
    i = (int) f; //소수점 이하의 수는 제거되고 정수만 저장된다
    System.out.println(i);
    i = (int) d;
    System.out.println(i);
    
    l = (long) f;//ok
    l = (long) d;//ok
    
    //이렇게 개발자가 명확하게 다른형의 값을 저장하라고 지시하는 문법을
    //명시적 형변환  
    
    
  }
}