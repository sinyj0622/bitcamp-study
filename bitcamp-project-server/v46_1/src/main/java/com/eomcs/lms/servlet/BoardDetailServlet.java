package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;
import com.eomcs.util.Component;
import com.eomcs.util.Prompt;

@Component("/board/detail")
public class BoardDetailServlet implements Servlet {

  // DAO 클래스를 구체적으로 지정하기 보다는
  // 인터페이스를 지정함으로써
  // 향후 다른 구현체로 교체하기 쉽도록 한다.
  //
  BoardService boardService;

  public BoardDetailServlet(BoardService boardService) {
    this.boardService = boardService;
  }


  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    int no = Prompt.getInt(in, out, "번호? ");

    Board board = boardService.get(no);

    if (board != null) {
      out.printf("번호: %d\n", board.getNo());
      out.printf("제목: %s\n", board.getTitle());
      out.printf("등록일: %s\n", board.getDate());
      out.printf("조회수: %d\n", board.getViewCount());

    } else {
      out.println("해당 번호의 게시물이 없습니다.");
    }
  }
}
