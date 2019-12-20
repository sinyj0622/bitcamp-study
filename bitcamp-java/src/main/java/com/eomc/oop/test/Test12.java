package com.eomc.oop.test;

// gym 회원 정보를 입력받아 출력한다
public class Test12 {

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
    
    // 인스턴스를 3000개 만들것이다
    // 레퍼런스를 3000개 준비하라
    
    // 다음과 같이 일반적인 방식으로 레퍼런스를 선언하면 너무 길어져서 코딩할수없다!
    //Member m0, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15;
    
    // 이런 상황에서 배열을 사용하면 쉽게 사용할수있다
    // 배열을 이용하면 많은 레퍼런스 변수를 쉽게 만들수있다
    
    // 레퍼런스 배열의 주소도 또한 레퍼런스 변수에 담아야한다
    // 주의
    // ***"member 인스턴스 주소를 담을 레퍼런스 변수"***를 3000개만든다
    //member 인스턴스를 3000개 만드는것이 아니다!!!!!!!!!!!!!
    Member[] arr = new Member[3000];
    
    int count = 0;
    while (count < 3000) {
      arr[count] = new Member();
      count++;
    }
    
    // 배열 문법을 이용하여 인스턴스를 3000개 만드는 방법은 없나요?
    // 없당!!
    
    
  }
  
  
}
