package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.BoardFObjectFileDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateServlet implements Servlet {


  BoardFObjectFileDao boardDao;

  public BoardUpdateServlet(BoardFObjectFileDao boardDao) {
    this.boardDao = boardDao;
  }


  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    Board board = (Board) in.readObject();


    if (boardDao.update(board) > 0) {
      out.writeUTF("OK");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 게시물이 없습니다.");
    }
  }
}
