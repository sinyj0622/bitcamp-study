package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;
import com.eomcs.util.Component;
import com.eomcs.util.Prompt;
import com.eomcs.util.RequestMapping;

@Component
public class BoardUpdateServlet {

  // DAO 클래스를 구체적으로 지정하기 보다는
  // 인터페이스를 지정함으로써
  // 향후 다른 구현체로 교체하기 쉽도록 한다.
  //
  BoardService boardService;

  public BoardUpdateServlet(BoardService boardService) {
    this.boardService = boardService;
  }

  @RequestMapping("/board/update")
  public void service(Scanner in, PrintStream out) throws Exception {

    int no = Prompt.getInt(in, out, "번호? ");

    Board old = boardService.get(no);
    if (old == null) {
      out.println("해당 번호의 게시글이 없습니다");
      return;
    }

    Board board = new Board();
    board.setTitle(Prompt.getString(in, //
        out, //
        String.format("제목(%s)? \n", old.getTitle()), //
        old.getTitle()));
    board.setNo(no);


    if (boardService.update(board) > 0) {
      out.println("게시글을 변경했습니다!");
    } else {
      out.println("게시글 변경에 실패했습니다.");
    }
  }
}
