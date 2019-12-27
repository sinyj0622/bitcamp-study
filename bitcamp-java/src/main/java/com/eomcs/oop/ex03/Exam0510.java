// 변수 초기화 - 자동 초기화
package com.eomcs.oop.ex03;

import java.sql.Date;

public class Exam0510 {
  static class A {
    static byte b;
    static short s;
    static int i;
    static long l;
    static char c;
    static float f;
    static double d;
    static boolean bool;
    static String str;
    static Date date;

     byte b2;
    short s2;
    int i2;
    long l2;
     char c2;
     float f2;
     double d2;
     boolean bool2;
     String str2;
     Date date2;


  }
  public static void main(String[] args) {
    int c;

    // ***클래스 변수는 생성되는 순간 0으로 자동 초기화 된다.
    // 정수(byte,short, int ,long,char) : 0
    // 부동소수점(float, double) : 0.0
    // 논리(boolean) : false
    System.out.printf("%d,%d,%d,%d,%c,%f,%f,%b,%s,%s\n",
        A.b,A.s,A.i,A.l,A.c,A.f,A.d,A.bool,A.str,A.date);


    // ***인스턴스 변수도 클래스 변수와 마찬가지다
    // => 
    A obj1 = new A();
    System.out.println(obj1.b);
    System.out.printf("%d,%d,%d,%d,%c,%f,%f,%b,%s,%s\n",
        obj1.b,obj1.s,obj1.i,obj1.l,obj1.c,obj1.f,obj1.d,obj1.bool,obj1.str,obj1.date);
    
    
    
    // ***로컬 변수는 자동 초기화되지 않는다.***
    // ***반드시 사용전에 값을 저장해야 한다.****
    //System.out.println(c); // 컴파일 오류!
    int i;
    String str;
    Date date;
    //System.out.println(i);
    //System.out.println(str);
    //System.out.println(date);
    
  } 
}




