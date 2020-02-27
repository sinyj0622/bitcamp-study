package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.sql.Connection;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.sql.DataSource;
import com.eomcs.sql.PlatformTransactionManager;
import com.eomcs.util.Prompt;

public class PhotoBoardDeleteServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  PlatformTransactionManager txManager;

  public PhotoBoardDeleteServlet(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao,
      PlatformTransactionManager txManager) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    this.txManager = txManager;
  }



  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? ");

    // 트랜잭션 시작
    txManager.beginTransaction();

    try {
      if (photoFileDao.deleteAll(no) == 0) {
        throw new Exception("해당 번호의 사진 게시글이 없습니다.");
      }

      if (photoBoardDao.delete(no) > 0) {
        txManager.commit();
        out.println("사진 게시글을 삭제했습니다.");

      }
    } catch (Exception e) {
      out.println(e.getMessage());
      txManager.rollback();
    } 
  }
}
