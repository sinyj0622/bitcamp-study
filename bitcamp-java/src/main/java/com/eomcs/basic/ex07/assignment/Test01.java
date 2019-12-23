package com.eomcs.basic.ex07.assignment;

public class Test01 {
  public static void main(String[] args) {
    // 배열의 값 중에서 최소 값을 출력하라.
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    
    int value = max(values); // 메서드 호출
    
    System.out.println(value);
    // 출력결과:
    // 78
  }
  
  static int max(int[] values) {
    

   int min = values[0];
       for (int i = 1; i <values.length; i++) {
         if (min > values[i]) {
           min = values[i];
         }
       }
    
    return min;
  }

}









