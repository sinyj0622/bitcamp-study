package com.eomcs.oop.ex03.test;


class Score {
  static int count; //모든 학생이 공유하는 클래스변수
  String name; //개별적으로 관리
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  

  Score(String name, int kor, int eng, int math) {   
    System.out.println("Score() - 2");
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
    Score.increase();
  }
  
  static void increase() {
    Score.count++;
  }
  
   void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}

public class Test01 {

  public static void main(String[] args) {
    
   Score s1 = new Score("홍길동", 100, 90, 80); 
   System.out.println("------");
   s1.name = "홍길동";
   s1.kor = 100;
   s1.eng = 90;
   s1.math = 80;
   s1.compute();  //s1이라는 인스턴스를 다룰 compute연산자실행

   
   Score s2 = new Score("임꺽정", 90, 80, 70);
   System.out.println("------");
  }
}
