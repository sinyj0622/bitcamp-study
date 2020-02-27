package com.eomcs.lms;

import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoBoardDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoFileDaoImpl;
import com.eomcs.sql.DataSource;
import com.eomcs.sql.PlatformTransactionManager;

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

      DataSource dataSource = new DataSource(jdbcUrl, usename, password);
      context.put("dataSource", dataSource);

      // 트랜잭션 관리자
      PlatformTransactionManager txManager = new PlatformTransactionManager(dataSource);
      context.put("txManager", txManager);

      context.put("boardDao", new BoardDaoImpl(dataSource));
      context.put("lessonDao", new LessonDaoImpl(dataSource));
      context.put("memberDao", new MemberDaoImpl(dataSource));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(dataSource));
      context.put("photoFileDao", new PhotoFileDaoImpl(dataSource));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    // 애플리케이션이 종료될때 모든 DB커넥션을 명시적으로 끊어준다
    // 그러면 DBMS는 TIMEOUT 될 까지 기다릴 필요가 없이
    // 클라이언트와 연결된 스레드를 즉시 해제 시킬 수있다.
    //
    DataSource dataSource = (DataSource) context.get("dataSource");
    dataSource.clean();
  }
}
