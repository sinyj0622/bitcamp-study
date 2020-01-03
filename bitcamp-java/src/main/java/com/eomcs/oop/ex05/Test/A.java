package com.eomcs.oop.ex05.Test;

public class A {
  
  int v1;
  
  A() {
    this(100);  //생성자안에서 또 다른 생성자를 호출할수있다
    System.out.println("A()");
  }
  
  A(int v1) {
    this.v1 = v1;
    System.out.println("A(int)");
  }
  
  
}
