package com.eomcs.oop.ex02.study;

public class GasStation {
  String name;
  int type;  //인스턴스 변수 (가스스테이션이 여러개로 개별적관리)
  
  int refuel(Car c) {   //인스턴스 변수를 사용할때만 static제거
    if (c.type != this.type)
      return 0;
    
    int amount = 100 - c.energy;
    c.energy = 100;
    return amount;
    
  }
  
  static void clean(Car c) { //인스턴스 필드를 사용하지 않는 메소드는 static을 붙인다
    c.cleanLevel = 0;
  }
  
  

}
