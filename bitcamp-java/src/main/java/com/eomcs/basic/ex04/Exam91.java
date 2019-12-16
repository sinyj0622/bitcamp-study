package com.eomcs.basic.ex04;


// 형변환 : 정수 변수 > 부동소수점 변수
public class Exam91 {
  
  
  public static void main(String[] args) {
   
    byte b = 100;
    short s = 200;
    int i = 1834566789;
    long l = 344_9876_9998_7654_3219L;
    
    float f;
    f = b;
    System.out.println(f);
    f = s;
    System.out.println(f);
    f = i;
    System.out.println(f);
    f = l;
    System.out.println(f); //큰수를 넣더라도 컴파일오류는 나지않지만 값이 짤릴수있다

    double d;
    d = b;
    System.out.println(d);
    d = s;
    System.out.println(d);
    d = i;
    System.out.println(d);
    d = l;
    System.out.println(d);
    
    
    
  }
}