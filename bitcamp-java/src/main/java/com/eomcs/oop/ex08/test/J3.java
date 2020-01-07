package com.eomcs.oop.ex08.test;

public class J3 {

  public void m1() {
    Student s = new Student();
    Teacher t = new Teacher();
    //Member m = new Member(); // 추상 클래스는 인스턴스를 생성 할수없다.
    // 즉 추상 클래스는 직접 사용할수없다.
    //단지 서브 클래스에게 공통 분모를 물려주는 일을 할뿐이다
  }

  //보통 일반화를 통해 정의한 수퍼 클래스는 직접 사용할 일이 없기 때문에 추상클래스로 정의하여 직접사용하지 않게 만든다.
  abstract class Member{
    String email;
    String pwd;
    String name;
    String tel;

    void print() {
      System.out.println("학생 정보");
    }
  }

  class Student extends Member{
    int grade;
    boolean working;

    @Override
    void print() {
      System.out.println("학생 정보");
    }
  }

  class Teacher extends Member{
    int pay;
    String major;

    @Override
    void print() {
      System.out.println("강사 정보");
    }
  }
}