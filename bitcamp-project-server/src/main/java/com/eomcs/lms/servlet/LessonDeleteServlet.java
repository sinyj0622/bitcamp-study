package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.Component;
import com.eomcs.util.Prompt;
import com.eomcs.util.RequestMapping;

@Component
public class LessonDeleteServlet {


  LessonService lessonService;

  public LessonDeleteServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }


  @RequestMapping("/lesson/delete")
  public void service(Scanner in, PrintStream out) throws Exception { // 예외를 던짐
    int no = Prompt.getInt(in, out, "번호? ");

    if (lessonService.delete(no) > 0) {
      out.println("수업을 삭제 했습니다.");

    } else {
      out.println("해당 번호의 수업이 없습니다.");
    }
  }
}
