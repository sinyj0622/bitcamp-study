package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class LoginFormServlet {

  MemberService memberService;

  public LoginFormServlet(MemberService memberService) {
    this.memberService = memberService;
  }



  @RequestMapping("/auth/loginForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원 로그인</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 로그인</h1>");
    out.println("<form action='/auth/login'>");
    out.println("이메일: <input name='email' type='text'><br>\n");
    out.println("비밀번호: <input name='password' type='text'><br>\n");
    out.println("<button>로그인</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");


  }

}
