package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.util.RequestMapping;

@Component
public class LessonAddFormServlet {


  @RequestMapping("/lesson/addForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception { // 예외를 던짐
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>게시글 입력</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시물 입력</h1>");
    out.println("<form action='/lesson/add'>");
    out.println("수업명: <input name='title' type='text'><br>\n");
    out.println("설명: <input name='description' type='text'><br>\n");
    out.println("시작일: <input name='startDate' type='date'><br>\n");
    out.println("종료일: <input name='endDate' type='date'><br>\n");
    out.println("총수업시간: <input name='totalHours' type='number'><br>\n");
    out.println("일수업시간: <input name='dayHours' type='number'><br>\n");
    out.println("<button>제출</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
}
