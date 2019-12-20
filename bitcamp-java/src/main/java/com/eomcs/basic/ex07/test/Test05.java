package com.eomcs.basic.ex07.test;

// gym 회원 정보를 입력받아 출력한다
public class Test05 {

  public static void main(String[] args) {
    
       //다양한 타입의 메모리를 연속으로 만든다(배열(배열은 같은 타입메모리)과 비슷)
    class Member {
    int no;
    String name;
    int birthYear;
    char gender;
    float height;
    float weight;
    boolean personalTraining;
    }
    
    
    Member m1;  
    m1 = new Member();
    m1.no = 100;
    System.out.println(m1); // 인스턴스에 부여된 고유번호와 클래스명이 출력된다
    System.out.println(m1.no);
    
    // 다른 레퍼런스에 주소를 저장할수있다
    Member m2 = m1;
    // m2는 m1과 같은 주소를 갖고 있다 즉 같은 인스턴스를 가리킨다
    System.out.println(m2.no);
    
    //m1 인스턴스를 m2 인스턴스로 복사한게 아니다
    m1.no = 200;
    System.out.println(m2.no);
  }
  
  
}
