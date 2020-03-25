package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class MemberSearchFormServlet {


  MemberService memberService;

  public MemberSearchFormServlet(MemberService memberService) {
    this.memberService = memberService;
  }


  @RequestMapping("/member/searchForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원 검색</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 검색</h1>");
    out.println("<form action='/member/search'>");
    out.println("검색어: <input name='memberSearch' type='text'><br>\n");
    out.println("<button>등록</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }

}

