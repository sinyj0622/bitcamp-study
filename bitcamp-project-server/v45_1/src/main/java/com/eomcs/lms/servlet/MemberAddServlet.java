package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.Prompt;

public class MemberAddServlet implements Servlet {


  MemberService memberService;

  public MemberAddServlet(MemberService memberService) {
    this.memberService = memberService;
  }


  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    Member member = new Member();

    member.setName(Prompt.getString(in, out, "이름? "));
    member.setEmail(Prompt.getString(in, out, "이메일? "));
    member.setPassword(Prompt.getString(in, out, "암호? "));
    member.setPhoto(Prompt.getString(in, out, "사진? "));
    member.setTel(Prompt.getString(in, out, "전화? "));
    out.flush();

    if (memberService.add(member) > 0) {
      out.println("새 회원을 등록했습니다!");

    } else {
      out.println("같은 번호의 회원이 있습니다.");
    }
  }
}
