package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.Prompt;

public class MemberUpdateServlet implements Servlet {


  MemberService memberService;

  public MemberUpdateServlet(MemberService memberService) {
    this.memberService = memberService;
  }


  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? ");

    Member oldMember = memberService.get(no);
    Member newMember = new Member();

    if (oldMember == null) {
      System.out.println("해당 번호의 게시글이 없습니다");
      return;
    }

    newMember.setNo(oldMember.getNo());
    newMember.setName(Prompt.getString(in, out, String.format("이름(%s)?", oldMember.getName())));
    newMember.setEmail(Prompt.getString(in, out, String.format("이메일(%s)?", oldMember.getEmail())));
    newMember
        .setPassword(Prompt.getString(in, out, String.format("암호(%s)?", oldMember.getPassword())));
    newMember.setPhoto(Prompt.getString(in, out, String.format("사진(%s)?", oldMember.getPhoto())));
    newMember.setTel(Prompt.getString(in, out, String.format("전화(%s)?", oldMember.getTel())));

    if (memberService.update(newMember) > 0) {
      out.println("회원정보를 변경했습니다!");
    } else {
      out.println("해당 번호의 회원이 없습니다.");
    }
  }
}
