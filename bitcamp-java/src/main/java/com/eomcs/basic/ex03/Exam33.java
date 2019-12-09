package com.eomcs.basic.ex03;

// 부동소수점 리터럴(literal) - 최소값과 최대값
public class Exam33 {
  public static void main(String[] args) {
    // 8바이트 부동소수점 최소/최대값
    System.out.println(Double.MAX_VALUE);
    System.out.println(Double.MIN_VALUE);

   // 4바이트 부동소수점 최소/최대값 (유효자리수 7자리)
   System.out.println(Float.MAX_VALUE);
   System.out.println(Float.MIN_VALUE);


   // 개발자가 부동소수점의 정확한 범위를 계산사기 쉽지않기때문에 2진수 변환규칙을 참고하여
   // '유효자릿수'를 사용하여 값의 범위를 정한다
   System.out.println(3.1415926535f); //값이 구겨진다
   System.out.println(3.141592653f); //값이 구겨진다
   System.out.println(3.14159265f); //값이 구겨진다
   System.out.println(3.1415926f); //값이 구겨진다
   System.out.println(3.141592f); //ok! 4바이트안에 값이 들어간다.
   System.out.println(314159.2f); //ok!
   System.out.println(31415.92f); //ok!
   System.out.println(3141.592f); //ok!
   System.out.println(3141592.25f); //값이 구겨진다

   // 4바이트 메모리에 저장할수 있는 부동소수점은 소숫점 위치에 상관없이 7개이면 정상적으로 저장하고 꺼낼수있다
   // 정상적으로 넣고 꺼낼 수 있는 부동소수점의 숫자 개수를 "유효자릿수" 라고 부른다
   // 주의~! 7자리라 하더라고 구겨질수있다. 정상적으로 작동하지 않을 수 있다. 
   // 그래서 부동소수점은 메모리에서 꺼낸값을 내부의 규칙에 따라 jvm이 보정해준다
   // 정확하게 저장되고 꺼내지 못하는이유?
   // 부동소수점을 2진수로 바꿀떄 IEEE 754 규칙에 따라 변경하는데, 
   // 이 규칙에서 일부 부동소수점은 2진수로 정확하게 변경되지 못하는 문제가 있다.

   System.out.println((1.1f + 0.2f) == 1.3f); //부동소수점의 오차

  }
}
