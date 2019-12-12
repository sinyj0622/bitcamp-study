package com.eomcs.basic.ex99;

public class Exam22 {
  public static void main(String[] args){
//# 키보드 입력 받기
      // 키보드 정보를 가져온다.
      java.io.InputStream keyboard = System.in;

      // 키보드에서 값을 꺼내주는 도구를 연결한다.
      java.util.Scanner scanner = new java.util.Scanner(keyboard);

      //줄바꿈표시=ENTER
      System.out.print("입력>");
      int i1 = scanner.nextInt();
      int i2 = scanner.nextInt();
      int i3 = scanner.nextInt();


     System.out.println("----------------------");
      
      System.out.println(i1);
      System.out.println(i2);
      System.out.println(i3);



      //nextInt()
      //SPACE TAB NEW LINE을 만나면 그앞까지 입력한 문자열을 int 값으로  바꿔 리턴ㄴ한다
      //입력한 문자열이 숫자를 의미하는 문자열이 아니라면 int 값으로 바꿀수 없기 때문에 오류


  }    
}