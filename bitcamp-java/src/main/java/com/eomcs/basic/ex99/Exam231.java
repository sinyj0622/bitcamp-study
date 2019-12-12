package com.eomcs.basic.ex99;

public class Exam231 {
  public static void main(String[] args){

       java.util.Scanner scanner = new java.util.Scanner(System.in);
      // nextInt()다음에 nextLine()을 호출할떄 공백문자가 읽히는 문제해결

      System.out.print("입력>");
      int i1 = scanner.nextInt();
      int i2 = scanner.nextInt();

      //공백만 그냥 읽는다.
      //next()
      // 한 개의 token(단어)을 읽는다
      // 공백을 만날떄까지 읽는다
      // 물론 nextInt()와 달리 값을 읽은후 뒤의 공백은 제거한다
      String s1 = scanner.next();

      String s2 = scanner.next();

      int i3 = scanner.nextInt();

      String s3 = scanner.next();



      System.out.println("----------------------");
      
      System.out.println(i1);
      System.out.println(i2);    
      System.out.println(i3);
      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s3);



      
      //nextLine() : 공백을 만나면 리턴


      //nextInt() - 커서 고민하기!
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