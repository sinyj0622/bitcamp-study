package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class MemberSearchServlet {


  MemberService memberService;

  public MemberSearchServlet(MemberService memberService) {
    this.memberService = memberService;
  }


  @RequestMapping("/member/search")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    String memberSearch = params.get("memberSearch");
    List<Member> members = memberService.search(memberSearch);

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>검색한 회원목록</h1>");

    if (members != null) {
      out.println("   <table border='1'>");
      out.println("   <tr>");
      out.println("     <th>번호</th>");
      out.println("     <th>이름</th>");
      out.println("     <th>이메일</th>");
      out.println("     <th>전화번호</th>");
      out.println("     <th>등록일</th>");
      out.println("   </tr>");
      for (Member m : members) {
        out.printf(" <tr>" //
            + "<td>%d</td> "//
            + "<td>%s</td> "//
            + "<td>%s</td> "//
            + "<td>%s</td>"//
            + "<td>%s</td>"//
            + "</tr>\n", //
            m.getNo(), m.getName(), m.getEmail(), m.getTel(), m.getRegisteredDate());
      }

      out.println("   <a href='/member/list'>목록</a><br>");
    } else {
      out.println("<p>검색 결과가 없습니다.</p>");
    }
    out.println("</body>");
    out.println("</html>");
  }

}

