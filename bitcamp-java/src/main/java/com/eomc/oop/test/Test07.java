package com.eomc.oop.test;

// gym 회원 정보를 입력받아 출력한다
public class Test07 {

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
    
    Member m2 = m1;
    
    m1 = new Member();
    m1.no = 200;
    
    m2 = m1;
    
    // 이제 m2도 m1과 같은 인스턴스 주소를 갖고있다
    // 즉 같은 인스턴스를 가리킨다
    
    
    
  }
  
  
}
