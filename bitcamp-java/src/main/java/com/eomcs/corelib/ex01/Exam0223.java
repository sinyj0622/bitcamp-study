// Wrapper 클래스 - auto-boxing/auto-unboxing 응용
package com.eomcs.corelib.ex01;

public class Exam0223 {

  static class Member{
    String name;
    String tel;

    @Override
    public String toString() {
      return name + "," + tel;
    }
  }

  public static void main(String[] args) {

    int i = 100;
    Member member = new Member();
    member.name = "홍길동";
    member.tel = "010-000-0000";

    String str = new String("Hello");

    // 자바가 Wrapper 클래스를 이용하여 오토박싱,오토언박싱 기능을 제공함으로써
    // primitive data type 또는 클래스의 인스턴스 구분없이 값을 편리하게 저장할 수 있게 되었다.
    Object obj;
    obj = member;
    obj = i;
    obj = str;
    
    

    String obj2 = (String) obj;
    
    System.out.println(str);
    System.out.println(obj);
    
  }

}





