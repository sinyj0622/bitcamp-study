package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateServlet implements Servlet {


  MemberDao memberDao;

  public MemberUpdateServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }


  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? ");
    out.println("!{}!");
    int no = Integer.parseInt(in.nextLine());

    Member oldMember = memberDao.findByNo(no);
    Member newMember = new Member();

    if (oldMember == null) {
      System.out.println("해당 번호의 게시글이 없습니다");
      return;
    }

    newMember.setNo(oldMember.getNo());

    out.printf("이름(%s)? \n", oldMember.getNo());
    out.println("!{}!");
    newMember.setName(in.nextLine());

    out.printf("이메일(%s)? \n", oldMember.getEmail());
    out.println("!{}!");
    newMember.setEmail(in.nextLine());

    out.printf("암호(%s)? \n", oldMember.getPassword());
    out.println("!{}!");
    newMember.setPassword(in.nextLine());

    out.printf("사진(%s)? \n", oldMember.getPhoto());
    out.println("!{}!");
    newMember.setPhoto(in.nextLine());

    out.printf("전화(%s)? \n", oldMember.getTel());
    out.println("!{}!");
    newMember.setTel(in.nextLine());

    if (memberDao.update(newMember) > 0) {
      out.println("회원정보를 변경했습니다!");
    } else {
      out.println("해당 번호의 회원이 없습니다.");
    }
  }
}
