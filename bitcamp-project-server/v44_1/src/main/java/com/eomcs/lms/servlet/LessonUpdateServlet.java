package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.Prompt;

public class LessonUpdateServlet implements Servlet {


  LessonService lessonService;

  public LessonUpdateServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }


  @Override
  public void service(Scanner in, PrintStream out) throws Exception { // 예외를 던짐
    int no = Prompt.getInt(in, out, "번호? ");

    Lesson oldLesson = lessonService.get(no);
    Lesson newLesson = new Lesson();

    if (oldLesson == null) {
      out.println("해당 번호의 게시글이 없습니다");
      return;
    }

    newLesson.setNo(oldLesson.getNo());
    newLesson.setTitle(Prompt.getString(in, out, String.format("수업명(%s)? ", oldLesson.getTitle())));
    newLesson.setDescription(
        Prompt.getString(in, out, String.format("설명(%s)? ", oldLesson.getDescription())));
    newLesson.setStartDate(
        Prompt.getDate(in, out, String.format("시작일(%s)? ", oldLesson.getStartDate())));
    newLesson
        .setEndDate(Prompt.getDate(in, out, String.format("종료일(%s)? ", oldLesson.getEndDate())));
    newLesson.setTotalHours(
        Prompt.getInt(in, out, String.format("총수업시간(%d)? ", oldLesson.getTotalHours())));
    newLesson
        .setDayHours(Prompt.getInt(in, out, String.format("일수업시간(%d)? ", oldLesson.getDayHours())));
    out.flush();


    if (lessonService.update(newLesson) > 0) {
      out.println("수업을 변경했습니다!");
    } else {
      out.println("해당 번호의 수업이 없습니다.");
    }
  }
}
