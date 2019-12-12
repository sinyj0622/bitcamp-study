package com.eomcs.basic.ex99;

public class Exam21 {
  public static void main(String[] args){
//# 키보드 입력 받기
      // 키보드 정보를 가져온다.
      java.io.InputStream keyboard = System.in;

      // 키보드에서 값을 꺼내주는 도구를 연결한다.
      java.util.Scanner scanner = new java.util.Scanner(keyboard);

      //줄바꿈표시=ENTER

      String s1 = scanner.nextLine();

      String s2 = scanner.nextLine();

      String s3 = scanner.nextLine();


      System.out.println("----------------------");
      
      
      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s3);


  
  }
}