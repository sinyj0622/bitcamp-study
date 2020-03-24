package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;
import com.eomcs.util.Prompt;
import com.eomcs.util.RequestMapping;

@Component
public class BoardAddServlet {

  // DAO 클래스를 구체적으로 지정하기 보다는
  // 인터페이스를 지정함으로써
  // 향후 다른 구현체로 교체하기 쉽도록 한다.
  //
  BoardService boardService;

  public BoardAddServlet(BoardService boardService) {
    this.boardService = boardService;
  }


  @RequestMapping("/board/add")
  public void service(Scanner in, PrintStream out) throws Exception { // 예외를 던짐

    Board board = new Board();

    board.setTitle(Prompt.getString(in, out, "제목? "));

    boardService.add(board);
    out.println("새 게시글을 등록했습니다");


  }

}
