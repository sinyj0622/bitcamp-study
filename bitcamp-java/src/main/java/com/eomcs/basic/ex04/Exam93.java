package com.eomcs.basic.ex04;


// 형변환 : 형변환 규칙
public class Exam93 {
  
  public static void main(String[] args) {
   byte b = 100;
   short s = 32767;
   int i = 210000000;
   long l = 9220000000000000000L;
   float f =3.14f;
       double d = 3.14d;
   
   //정수 메모리끼리 형변환가능
    l = i;
    
    l = i;
    i = s;
    s = b;
    
    
    i = (int) l; //단 값이 짤린다
    s = (short) i; //단 값이 짤린다
    b = (byte) s; //단 값이 짤린다
    
    // 정수를 부동소수점 메모리에 저장가능. 명시적 형변환 필요없음
    // 숫자를 문자 변수에 저장가능
    
    i = 65;
    char c = (char) i;
    System.out.println(c);
    
    //그외 형변환 불가!!!!!!!
    //boolean bool;
    //bool = (boolean) b; //컴파일오류
    //bool = s;
    //bool = i;
    //bool = l;
    //bool = f;
    //bool = d;
    //bool = c;
    
    //bool = "true"; //오류
    //i = "10";
    //c = (char)"가";
    //f = "3.14f";
    
    //i = bool; //컴파일오류
    //c = bool;
    //f = bool;
    
    
    
    
    
    
  
  }
}