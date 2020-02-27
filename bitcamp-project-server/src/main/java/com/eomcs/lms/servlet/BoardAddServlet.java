package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardAddServlet implements Servlet {
  //
  BoardDao boardDao;


  public BoardAddServlet(BoardDao boardDao) {
    this.boardDao = boardDao;
  }


  @Override
  public void service(Scanner in, PrintStream out) throws Exception { // 예외를 던짐

    Board board = new Board();

    board.setTitle(Prompt.getString(in, out, "제목? "));

    if (boardDao.insert(board) > 0) { // 등록했다면
      out.println("새 게시글을 등록했습니다");

    } else {
      out.println("게시글 등록에 실패하였습니다.");
    }
  }

}
