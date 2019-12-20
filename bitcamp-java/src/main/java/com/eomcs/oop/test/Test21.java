package com.eomcs.oop.test;

// gym 회원 정보를 입력받아 출력한다
public class Test21 {

  static class Member {
    int no;
    String name;
    int birthYear;
    char gender;
    float height;
    float weight;
    boolean personalTraining;
  }
  
  public static void main(String[] args) {
    
       //다양한 타입의 메모리를 연속으로 만든다(배열(배열은 같은 타입메모리)과 비슷)

    // 인스턴스 주소 주고 받기 
    
    //1.인스턴스 주소 받기
    Member m1;
    m1 = createMember();
    
    //2.인스턴스의 주소 넘기기
    setMemberValues(m1); //값저장
   
    
    printMember(m1);
    
  }
  
  static Member createMember() {
    Member m = new Member();
    return m;
    
  }
  
  
  static void setMemberValues (Member m) {
    m.no = 100;
    m.name = "홍길동";
    m.birthYear = 2000; 
    
  }
                         //외부에서 받은 파라미터
  static void printMember(Member m) {
    System.out.println(m.no);
    System.out.println(m.name);
    System.out.println(m.birthYear);
    
  }
}
