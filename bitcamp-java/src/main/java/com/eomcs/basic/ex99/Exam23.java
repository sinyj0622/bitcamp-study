package com.eomcs.basic.ex99;

public class Exam23 {
  public static void main(String[] args){

       java.util.Scanner scanner = new java.util.Scanner(System.in);

      // 정수와 문자열 한줄을 입력 받기
      System.out.print("입력>");
      int i1 = scanner.nextInt();
      int i2 = scanner.nextInt();
      String s = scanner.nextLine();


     System.out.println("----------------------");
      
      System.out.println(i1);
      System.out.println(i2);
      System.out.println(s);

      

      //nextInt() - 앞부분 공백 무시
      //=>SPACE, TAB, NEW LINE을 만나면 그 앞까지 입력한 문자열을 int 값으로  바꿔 리턴k한다
      //입력한 문자열이 숫자를 의미하는 문자열이 아니라면 int 값으로 바꿀수 없기 때문에 오류
      //=>현재 커서의 위치는 공백(white space :SPACE, TAB, NEW LINE)에 있다
      //***즉 값을 읽고 난후 공백을 제거하지 않는다.
      //=> 그래서 다음 메서드는 공백부터 읽게된다
      //=> nextInt() 앞에 공백이 있으면 무시한다 다음공백을 만날 때까지 읽는다
      

      //결론!
      //nextInt() 다음에 nextLine()을 실행할때 nextLine()은 nextInt()가 읽은값 다음부터 읽기 때문에 기대하지 않는 값이 리턴될수있다


  }    
}