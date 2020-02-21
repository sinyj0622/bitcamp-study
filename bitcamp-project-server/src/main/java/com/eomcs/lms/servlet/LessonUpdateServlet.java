package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateServlet implements Servlet {


  LessonDao lessonDao;

  public LessonUpdateServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void service(Scanner in, PrintStream out) throws Exception { // 예외를 던짐
    out.println("번호? ");
    out.println("!{}!");
    int no = Integer.parseInt(in.nextLine());

    Lesson oldLesson = lessonDao.findByNo(no);
    Lesson newLesson = new Lesson();

    if (oldLesson == null) {
      System.out.println("해당 번호의 게시글이 없습니다");
      return;
    }

    newLesson.setNo(oldLesson.getNo());
    out.printf("수업명(%s)? \n", oldLesson.getTitle());
    out.println("!{}!");
    newLesson.setTitle(in.nextLine());

    out.printf("설명(%s)? \n", oldLesson.getTitle());
    out.println("!{}!");
    newLesson.setDescription(in.nextLine());

    out.printf("시작일(%s)? \n", oldLesson.getStartDate());
    out.println("!{}!");
    newLesson.setStartDate(Date.valueOf(in.nextLine()));

    out.printf("종료일(%s)? \n", oldLesson.getEndDate());
    out.println("!{}!");
    newLesson.setEndDate(Date.valueOf(in.nextLine()));

    out.printf("총수업시간(%d)? \n", oldLesson.getTotalHours());
    out.println("!{}!");
    newLesson.setTotalHours(Integer.parseInt(in.nextLine()));

    out.printf(String.format("일수업시간(%d)? \n", oldLesson.getDayHours()));
    out.println("!{}!");
    newLesson.setDayHours(Integer.parseInt(in.nextLine()));
    out.flush();


    if (lessonDao.update(newLesson) > 0) {
      out.println("수업을 변경했습니다!");
    } else {
      out.println("해당 번호의 수업이 없습니다.");
    }
  }
}
