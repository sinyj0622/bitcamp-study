package com.eomcs.oop.ex02.study;

public class Test02 {
  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?
    // 3 * 2 + 7 / 4 - 5 = ?
    
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();
    
    // static 변수의 문제점
    // calculator의 result 변수는 static 이라서
    // 클래스에 한개만 존재한다
    // 다음과 같이 따라서 여러개의 결과를 동시에 관리할수없다
    // 오직 한번에 한개의 결과만 관리할수있다
    // 그래서 한개의 식을 끝낸 다음에 다른 식을 계산해야 한다
    // 결과를 개별적으로 관리 하고싶다면 non-static 필드로 선언하라!
    // 즉 인스턴스 마다 따로 생성되게 하라
    // 인스턴스 필드로 만들면된다
    
    //개별적으로 값을 관리해야될경우에는 인스턴스필드를 사용해라!!!!!!!!!!!
    
    // 메서드를 호출할떄 어떤 result변수에 그 계산 결과를 저장할것인디 파라미터로 인스턴스 주소를 넘겨야한다
    c1.plus(2);
    c2.plus( 3);
    
    c1.plus(3);
    c2.multiple(2);
    
    c1.mimus(1);
    c2.plus(7);
    
    c1.multiple(7);
    c2.divide(4);
    
    c1.divide(3);
    c2.mimus(5);
    
    
    System.out.printf("식1의 결과:%d\n", c1.result);
    System.out.printf("식2의 결과:%d\n", c2.result);
    
    
    
    
    
  }
  
  

  
}
