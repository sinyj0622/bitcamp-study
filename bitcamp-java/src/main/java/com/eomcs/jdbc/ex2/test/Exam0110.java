// 게시판 관리 - 등록
package com.eomcs.jdbc.ex2.test;

import java.sql.DriverManager;
import java.util.Scanner;

// 다음과 같이 게시물을 등록하는 프로그램을 작성하라!
// ----------------------------
// 제목? aaa
// 내용? bbb
// 등록하시겠습니까?(Y/n) y
// 등록하였습니다.
// 등록하시겠습니까?(Y/n) n
// 등록을 취소 하였습니다.
// ----------------------------
public class Exam0110 {

  public static void main(String[] args) throws Exception {

    Scanner keyScan = new Scanner(System.in);

    String title;
    String contents;
    try (
        java.sql.Connection con = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        java.sql.Statement stmt = con.createStatement();) {

      System.out.print("제목? ");
      title = keyScan.nextLine();
      System.out.print("내용? ");
      contents = keyScan.nextLine();

      System.out.print("등록하시겠습니까?(Y/n)");
      String response = keyScan.nextLine();

      if (!response.equalsIgnoreCase("y") || response.length() == 0) {
        System.out.print("등록을 취소 하였습니다.");
        return;
      }

      if (response.equals("y")) {
        int count = stmt.executeUpdate(
            "insert into x_board(title,contents) value('" + title + "','" + contents + "')");
        System.out.printf("%d 개 입력했습니다", count);

      } else {
        System.out.print("등록을 취소 하였습니다.");
      }
    }
    keyScan.close();

  }
}


