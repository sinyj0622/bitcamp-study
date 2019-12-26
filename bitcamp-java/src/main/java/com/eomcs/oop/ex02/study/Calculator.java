package com.eomcs.oop.ex02.study;

public class Calculator {

  // 메서드가 작업한 (중간)결과를 보관하기 위해 필드 문법을 도입
  // 계산결과를 개별적으로 관리하고 싶다면 인스턴스 필드로 선언해야한다
  int result; //자동초기화0

  // 개별적으로 관리되는 인스턴스 변수 result를 사용하고 싶다면, 파라미터롤 인스턴스의 주소를 받아야한다
  // 스태틱 메서드에서 인스턴스 의 필드의 메서드를 사용할수없다
  // 인스턴스 필드나 인스턴스 메서드를 사용하려면 파라미터로 인스턴스 주소를 받아야한다 reserved keyword
  void plus(int value) {
    this.result += value;
  }
  void mimus(int value) {
    this.result -= value;
  }
  void multiple(int value) {
    this.result *= value;
  }
  void divide(int value) {
    this.result /= value;
  }


}
