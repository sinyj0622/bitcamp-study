package com.eomcs.oop.ex09.e.project4;

import com.eomcs.oop.ex09.e.Computer;


// 4번쨰 프로젝트에서 터치 기능이 들어간 새 컴퓨터를 만들기로 했다.
// 방법1)
// 터치 기능이 추가된 새 규칙(computer2)을 정의한다.
// 그리고 새 컴퓨터(newcomputer1)는 그 규칙에 따라 만든다
public class NewComputer1 implements Computer {
  
    // 기존 규칙을 구현하고,
    public void compute() {
        System.out.println("새 컴퓨터..");
    }
    
    
    // 새로 추가한 규칙도 구현한다.
    // 새로 추가한 규칙을 정의하는 것은 개발자 마음이다.
    // => 즉 나중에 추가한 touch() 메서드를 구현하는 것은 개발자 마음!
    public void touch() {
        System.out.println("오호라.. 터치가 되네. 이거 서피스 프로인가?");
    }

}






