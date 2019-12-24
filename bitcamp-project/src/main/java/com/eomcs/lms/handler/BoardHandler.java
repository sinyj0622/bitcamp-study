package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {

  // 인스턴스 필드 = non-static field
  // new 명령을 실행해야만 생성되는 변수이다
  // non-static '개별적으로 관리되어야 하는 값일경우' 인스턴스 필드로 선언한다
  //
  Board[] boards = new Board[BOARD_SIZE];  //static이 붙지 않으면 여러개 생성가능
  int boardCount = 0;

  // 클래스 필드 = static field
  // METHOD AREA에 클래스 코드가 로딩될떄 자동 생성된다
  // 공통으로 사용할 값일 경우 클래스 필드로 선언한다
  //
  static final int BOARD_SIZE = 100;
  public static Scanner keyboard; //공유

  // 클래스 메서드
  // 인스턴스 없이 호출하는 메서드이다
  // 인스턴스를 사용하려면 파라미터를 통해 호출할때 외부에서 받아야한다
  //
  public static void listBoard(BoardHandler boardHandler) {
    for (int i = 0; i < boardHandler.boardCount; i++) {  
      Board b = boardHandler.boards[i];
      System.out.printf("%d, %s, %s, %s\n", 
          b.no, b.title, b.date, b.viewCount);

    }
  }


  public static void addBoard(BoardHandler boardHandler) { 
    Board board = new Board();  

    System.out.print("번호? ");
    board.no = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("내용? ");
    board.title = keyboard.nextLine();

    board.date = new Date(System.currentTimeMillis());
    board.viewCount = 0;


    boardHandler.boards[boardHandler.boardCount++] = board;
    System.out.println("저장하였습니다.");    

  }




  public static void detailBoard(BoardHandler boardHandler){
    System.out.print("게시물 번호? ");
    int no =keyboard.nextInt();
    keyboard.nextLine(); //숫자뒤에 남은 공백제거

    Board board = null;
    for(int i =0;  i < boardHandler.boardCount; i++) {
      if (boardHandler.boards[i].no == no) {
        board = boardHandler.boards[i];
        break;  //게시물 번호와 번호가 같게 만들기
      }
    }


    if (board == null) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
    }


    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("등록일: %s\n", board.date);
    System.out.printf("조회수: %d\n", board.viewCount);

  }


}
