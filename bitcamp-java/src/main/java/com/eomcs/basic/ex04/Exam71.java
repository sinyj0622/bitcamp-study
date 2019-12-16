package com.eomcs.basic.ex04;


// 변수의 종류
public class Exam71 {
  
  int instanceVar; //인스턴스 필드(변수)
  static int classVar; //클래스 필드(변수) = 스태틱 필드(변수)
  
  
  public static void main(String[] args/*로컬변수(파라미터)*/){
   
    // 로컬 변수
    // 메서스 블록안에 선언된 변수
    // 매서드 블록을 벗어사서 사용할수없다
    int local; //로컬변수
    int lacal2;


    classVar = 200; //ok
    
    //static이 안붙은 인스턴스 변수는 사용할수없다
    //instanceVar = 300; //컴파일오류

  }
  //클래스 메서드 = 스태틱 메서드
  static void m1() {
    //메서드 블록이 다르면 변수도 다르다
    //그래서 같은 이름의 변수를 선언할수있다
    int local; 
    
    //다른 메서드 블록에 있는 변수를 사용할수없다
    //local2 = 200; //컴파일오류
    
    //같은 static 멤버는 사용할수있다
    classVar = 100; //ok!
    
    
    
  }
  //인스턴스 메서드
  void m2() {
    int local; //ok
    
    classVar = 200; //static 멤버 사용가능
    instanceVar = 200; //ok static 이 안붙은 변수 사용가능
    
    
    
    
    
  }
}