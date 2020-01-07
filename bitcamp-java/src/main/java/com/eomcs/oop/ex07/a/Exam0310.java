//# 캡슐화 문법 사용 후 - 캡슐화와 게터/세터
// 캡슐화 : 인스턴스 필드,메서드,클래스 필드,메서드의 접근범위를 조정해서 잘못 사용하는 것을 방지한다
package com.eomcs.oop.ex07.a;

class Score4 {
  
  // 실무에서는 보통 필드의 직접 접근을 막는다.
  // 일관성을 유지하기위해 *가능한 세터를 통해 값을 설정하도록 유도하고
  // 게터를 통해 값을 조회하도록 유도한다*
  // 그래서 name 필드처럼 굳이 세터나 게터가 필요없는 경우에도 세터/게터를 만든다.
  // => 즉 필드는 캡슐화 문법을 통해 외부의 접근을 제한하고,
  //    세터/게터 메서드를 통해 값을 설정/조회하게 만든다.
  //
  // => name , kor, eng, math 필드 같은 경우
  //    값을 설정하고 조회도 해야 하기 때문에 게터/세터가 모두 있다
  // => sum, aver 필드 같은 경우
  //    값을 조회만 해야 하기 때문에 게터만 있다.
  // => 이렇게 필드에 대해서 항상 게터/세터를 모두 만드는 것이 아니다..
  //
  // 용어
  // =>  name, kor, eng, math, sum, aver 는 "필드(field)"라 부른다
  // => ******gerXxx()/setXxx()는 '프로퍼리(property)'라 부른다****** 
  // => 필드를 프로퍼티라 부르는 것이 아니다
  //    게터/세터를 프로퍼티라 부르는 것이다

  
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;
  // 국, 영, 수 점수를 바꿀 때 마다 자동으로 합계, 평균을 계산해야한다.
  // 방법?
  // => 직접 필드의 값을 바꾸게 하지 말고 메서드를 통해 바꾸도록 유도한다.
  // => 이렇게 '필드의 값을 바꿀 때 마다 뭔가를 수행해야 하는 경우',
  //    해당 필드의 직접 접근을 막아라!!!
  
  // 대신 메서드를 통해 값을 설정하게 하라!
  // 보통 필드의 값을 설정하는 메서드는 set필드명()으로 이름을 짓는다
  // => 이런 메서드를 "세터(setter)"라 부른다.
  // => 외부에서 호출할 수 있도록 public 공개 모드로 공개한다
  // => 필드를 비공개로 막으면 값을 조회할 수 없기 때문에
  // => getter를 추가해야한다.
  
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }
  
  public void setKor(int kor) {
    this.kor = kor;
    this.compute();
  }
  
  public int getKor()
  {
    return this.kor;
  }
  
  public void setEng(int eng) {
    this.eng = eng;
    this.compute();
  }
  
  public int getEng()
  {
    return this.eng;
  }
  
  public void setMath(int math) {
    this.math = math;
    this.compute();
  }
  
  public int getMath()
  {
    return this.math;
  }
 
  public int getSum() {
    return this.sum;
  }
  
  public float getAver() {
    return this.aver;  // 각각의 값을 조회하는 get도 추가해줘야함
  }
  
  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}


public class Exam0310 {
  public static void main(String[] args) {
    Score4 s1 = new Score4();
    s1.setName("홍길동");
    s1.setKor(100);
    s1.setEng(90);
    s1.setMath(80);
    
   
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
        s1.getName(), s1.getKor(), s1.getEng(), s1.getMath(), s1.getSum(), s1.getAver());

  }
}
