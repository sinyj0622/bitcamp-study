package com.eomcs.lms;

import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoBoardDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoFileDaoImpl;

// 애플리케이션이 시작되거나 종료될 때
// 데이터를 로딩하고 저장하는 일을 한다.
//
public class DataLoaderListener implements ApplicationContextListener {


  @Override
  public void contextInitialized(Map<String, Object> context) {

    try {
      // DB 연결정보
      String jdbcUrl = "jdbc:mariadb://localhost/studydb";
      String usename = "study";
      String password = "1111";


      context.put("boardDao", new BoardDaoImpl(jdbcUrl, usename, password));
      context.put("lessonDao", new LessonDaoImpl(jdbcUrl, usename, password));
      context.put("memberDao", new MemberDaoImpl(jdbcUrl, usename, password));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(jdbcUrl, usename, password));
      context.put("photoFileDao", new PhotoFileDaoImpl(jdbcUrl, usename, password));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {}
}
