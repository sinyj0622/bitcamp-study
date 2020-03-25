package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class MemberUpdateFormServlet {


  MemberService memberService;

  public MemberUpdateFormServlet(MemberService memberService) {
    this.memberService = memberService;
  }


  @RequestMapping("/member/updateForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    int no = Integer.parseInt(params.get("no"));

    Member member = memberService.get(no);

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원 정보 변경</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 정보 변경</h1>");

    if (member == null) {
      out.println("<p>해당 번호의 회원이 없습니다</p>");
    } else {

      out.println("<form action='/member/update'>");
      out.printf("번호: <input name='no' readonly type='text' value='%d'><br>\n", member.getNo());
      out.printf("이름: <input name='name' type='text'><br>\n", member.getName());
      out.printf("이메일: <input name='email' type='text'><br>\n", member.getEmail());
      out.println("비밀번호: <input name='password' type='text'><br>\n");
      out.printf("사진: <input name='photo' type='text'><br>\n", member.getPhoto());
      out.printf("전화: <input name='tel' type='text'><br>\n", member.getTel());
      out.printf("<button>변경</button>");
      out.printf("</form>");
    }
    out.println("</body>");
    out.println("</html>");

  }
}
