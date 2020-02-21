package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateServlet implements Servlet {


  LessonDao lessonDao;

  public LessonUpdateServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception { // 예외를 던짐
    Lesson lesson = (Lesson) in.readObject();


    if (lessonDao.update(lesson) > 0) {
      out.writeUTF("OK");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 수업이 없습니다.");
    }
  }
}