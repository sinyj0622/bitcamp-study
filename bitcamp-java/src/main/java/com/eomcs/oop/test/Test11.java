package com.eomcs.oop.test;

// gym 회원 정보를 입력받아 출력한다
public class Test11 {

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
    // 여러개의 인스턴스 주소를 저장하려면 당연히 여러개의 레퍼런스가 필요하다
    // 레퍼런스 변수를 여러개 만들기
    Member m0, m1, m2, m3, m4;
    
    // 인스턴스를 생성하여 각 레퍼런스 (변수)에 저장하기
    m0 = new Member();
    m1 = new Member();
    m2 = new Member();
    m3 = new Member();
    m4 = new Member();
    
    m0.no = 100;
    m1.no = 200;
    m2.no = 300;
    m3.no = 400;
    m4.no = 500;
    
    
  }
  
  
}
