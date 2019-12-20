package com.eomcs.basic.ex07.test;

// gym 회원 정보를 입력받아 출력한다
public class Test02 {

  public static void main(String[] args) {
    
    // 대신 자바에서는 다양한 종류의 데이터를 담을수 있는 메모리를 설계하는 문법을 제공한다
    
    //예 : 회원 데이터를 저장할 메모리를 설계한다 (식판)
    // class=설계도
    class Member {
    int no;
    String name;
    int birthYear;
    char gender;
    float height;
    float weight;
    boolean personalTraining;
    }
    
    //이렇게 개발자가 임의로 만든 데이터 타입
    // "사용자 정의 데이터 타입" user define data type
    // 개발자가 class라는 문법으로 정의한 데이터타입으로 메모리를 만들때는
    // 일반적인 방식으로 만들 수 없다
    // new 명령을 사용해야한다.
    // 준비된 메모리를 사용하기 위해서는 그 메모리의 주소를 변수에 보관해야 한다.
    // 이렇게 클래스 설계도로 만든 메모리의 주소를 저장하는 변수를 "레퍼런스" 라고한다
    Member m1 = new Member();
    
    // m1
    // - member 설계도에 따라 준비된 메모리의 주소(인스턴스=객체)를 저장할 변수
    // 이렇게 인스턴스의 주소를 저장하는 변수를 "레퍼런스"라고한다
    
    // new Member()
    // - member 설계도에 따라 메모리를 준비 시키는 명령
    // 
    
    m1.no = 100;
    m1.name = "홍길동";
    m1.birthYear = 2001;
    m1.height = 180.5f;
    m1.personalTraining = true;
    
  }
  
  
}
