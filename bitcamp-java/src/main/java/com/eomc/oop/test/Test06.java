package com.eomc.oop.test;

// gym 회원 정보를 입력받아 출력한다
public class Test06 {

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
    
    // 기존 레퍼런스에 새 인스턴스의 주소를 저장한다
    // 따라서 m1과 m2는 서로다른 인스턴스 주소를 갖고있다
    // 가리키는 인스턴스가 다르다
    m1 = new Member(); //인스턴스 주소가 다름 
    m1.no = 200;
    
    System.out.println(m1.no);
    System.out.println(m2.no);
    
    
    
  }
  
  
}
