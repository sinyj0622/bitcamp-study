// 게시판 관리 - 변경
package com.eomcs.jdbc.ex2.test;

import java.sql.DriverManager;
import java.util.Scanner;

// 다음과 같이 게시물을 변경하는 프로그램을 작성하라!
// ----------------------------
// 번호? 1
// 제목? xxx
// 내용? xxxxx
// 변경하였습니다.
// (또는)
// 해당 번호의 게시물이 존재하지 않습니다.
// ----------------------------
public class Exam0140 {

  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);

    String no;
    String title;
    String contents;
    try (
        java.sql.Connection con = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        java.sql.Statement stmt = con.createStatement();) {

      System.out.printf("번호? ");
      no = keyScan.nextLine();
      System.out.print("제목? ");
      title = keyScan.nextLine();
      System.out.print("내용? ");
      contents = keyScan.nextLine();


      int count = stmt.executeUpdate("update x_board set title='" + title + "',contents='"
          + contents + "' where board_id=" + no);

      if (count > 0) {
        System.out.println("변경하였습니다.");
      } else {
        System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
      }

      keyScan.close();
    }

  }
}


