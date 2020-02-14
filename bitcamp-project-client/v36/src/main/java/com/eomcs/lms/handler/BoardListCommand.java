package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.eomcs.lms.dao.BoardDao;


// "/board/list" 명령어 처리
public class BoardListCommand implements Command {

  BoardDao boardDao;

  public BoardListCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {
    try {

      // List<Board> boards = boardDao.findAll();

      // JDBC Driver(MariaDB 프록시) 로딩
      Class.forName("org.mariadb.jdbc.Driver");


      Connection con =
          DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("select board_id, conts, cdt, vw_cnt from lms_board");

      while (rs.next()) {
        System.out.printf("%d, %s, %s, %d\n", rs.getInt("board_id"), rs.getString("conts"),
            rs.getDate("cdt"), rs.getInt("vw_cnt"));

      }

      rs.close();
      stmt.close();
      con.close();
    } catch (Exception e) {
      System.out.println("목록 조회 실패!");
    }
  }


}


