package com.eomcs.lms.servlet;

import java.io.PrintWriter;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonUpdateFormServlet {


  LessonService lessonService;

  public LessonUpdateFormServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }


  @RequestMapping("/lesson/updateForm")
  public void service(Map<String, String> params, PrintWriter out) throws Exception { // 예외를 던짐
    int no = Integer.parseInt(params.get("no"));

    Lesson lesson = lessonService.get(no);

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>수업 게시글 변경</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>수업 게시물 변경</h1>");

    if (lesson == null) {
      out.println("<p>해당 번호의 수업 게시글이 없습니다</p>");
    } else {
      out.println("<form action='/lesson/update'>");
      out.printf("번호: <input name='no' readonly type='text' value='%d'><br>\n", lesson.getNo());
      out.printf("수업명: <input name='title' type='text'><br>\n", lesson.getTitle());
      out.printf("설명: <input name='description' type='text'><br>\n", lesson.getDescription());
      out.printf("시작일: <input name='startDate' type='text'><br>\n", lesson.getStartDate());
      out.printf("종료일: <input name='endDate' type='text'><br>\n", lesson.getEndDate());
      out.printf("총수업시간: <input name='totalHours' type='text'><br>\n", lesson.getTotalHours());
      out.printf("일수업시간: <input name='dayHours' type='text'><br>\n", lesson.getDayHours());
      out.printf("<button>변경</button>");
      out.printf("</form>");
    }
    out.println("</body>");
    out.println("</html>");

  }
}
