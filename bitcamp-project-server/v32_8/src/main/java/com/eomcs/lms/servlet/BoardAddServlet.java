package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.BoardFObjectFileDao;
import com.eomcs.lms.domain.Board;

public class BoardAddServlet implements Servlet {


  BoardFObjectFileDao boardDao;

  public BoardAddServlet(BoardFObjectFileDao boardDao) {
    this.boardDao = boardDao;
  }


  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception { // 예외를 던짐

    Board board = (Board) in.readObject();

    if (boardDao.insert(board) > 0) { // 등록했다면
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("같은 번호의 게시물이 있습니다.");
    }
  }

}