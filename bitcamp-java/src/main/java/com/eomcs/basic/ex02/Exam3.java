package com.eomcs.basic.ex02;

public class Exam3 {
  public static void main(String[] args) {
    
    System.out.println("애노테이션");
    
    
  }
  @Override // @컴파일러에게 기능을 재정의함을 알리는 명령이다 @Deprecated : ex)전에 기능을 사용하지말고 새로 사용해
  public String toString() {
    return "okok";
  }
}