package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;
import com.eomcs.util.RequestMapping;

@Component
public class BoardListServlet {

  // DAO 클래스를 구체적으로 지정하기 보다는
  // 인터페이스를 지정함으로써
  // 향후 다른 구현체로 교체하기 쉽도록 한다.
  //
  BoardService boardService;

  public BoardListServlet(BoardService boardService) {
    this.boardService = boardService;
  }


  @RequestMapping("/board/list")
  public void service(Scanner in, PrintStream out) throws Exception {
    List<Board> boards = boardService.list();
    for (Board board : boards) {
      out.printf("%d, %s, %s, %d\n", board.getNo(), board.getTitle(), board.getDate(),
          board.getViewCount());

    }
  }
}
