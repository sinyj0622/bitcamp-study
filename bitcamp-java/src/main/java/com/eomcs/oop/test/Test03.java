package com.eomcs.oop.test;

// gym 회원 정보를 입력받아 출력한다
public class Test03 {

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
    
    int i; // 자바 원시 데이터 타입은 변수를 선언하는 순간 메모리도 준비된다
    // 변수가 곧 메모리다
    
    i = 100; //ok
    
    // 그러나 레퍼런스는 메모리의 주소를 담는 변수다
    // 레퍼런스를 선언했다고 해서 해당 설계도의 메모리가 준비되는것은 아니다
    
    Member m1;  
    
    // m1은 메모리의 주소를 저장하는 변수이다
    // m1.no = 100;
    
    //m1을 사용하려면 메모리(인스턴스)를 생성한 다음에 주소를 할당해야한다
    m1 = new Member();
    // 클래스의 레퍼런스 사용법
    m1.no = 100;
    
  }
  
  
}
