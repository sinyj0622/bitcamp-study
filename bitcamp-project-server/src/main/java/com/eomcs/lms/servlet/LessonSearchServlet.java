package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonSearchServlet {

  LessonService lessonService;

  public LessonSearchServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/search")
  public void service(Map<String, String> searchParams, PrintStream out) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    String keyword = searchParams.get("title");
    if (keyword.length() > 0) {
      params.put("title", keyword);
    }
    keyword = searchParams.get("startDate");
    if (keyword.length() > 0) {
      params.put("startDate", keyword);
    }

    keyword = searchParams.get("endDate");
    if (keyword.length() > 0) {
      params.put("endDate", keyword);
    }

    keyword = searchParams.get("totalHours");
    if (keyword.length() > 0) {
      params.put("totalHours", Integer.parseInt(keyword));
    }

    keyword = searchParams.get("dayHours");
    if (keyword.length() > 0) {
      params.put("dayHours", Integer.parseInt(keyword));
    }

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>수업 검색 결과</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("   <h1>수업 검색 결과</h1>");

    List<Lesson> lessons = lessonService.search(params);
    if (lessons != null) {
      out.println("   <table border='1'>");
      out.println("   <tr>");
      out.println("     <th>번호</th>");
      out.println("     <th>제목</th>");
      out.println("     <th>시작일</th>");
      out.println("     <th>종료일</th>");
      out.println("     <th>총 수업시간</th>");
      out.println("   </tr>");

      for (Lesson l : lessons) {
        out.printf(" <tr>" //
            + "<td>%d</td> "//
            + "<td>%s</td> "//
            + "<td>%s</td> "//
            + "<td>%s</td>"//
            + "<td>%d</td>"//
            + "</tr>\n", //
            l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
      }
      out.println("   <a href='/lesson/list'>목록</a><br>");
    } else {
      out.println("<p>검색 결과가 없습니다.</p>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
