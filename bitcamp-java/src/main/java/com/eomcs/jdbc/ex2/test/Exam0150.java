// 게시판 관리 - 삭제
package com.eomcs.jdbc.ex2.test;

import java.sql.DriverManager;
import java.util.Scanner;

// 다음과 같이 게시물을 삭제하는 프로그램을 작성하라!
// ----------------------------
// 번호? 1
// 삭제하였습니다.
// (또는)
// 해당 번호의 게시물이 존재하지 않습니다.
// ----------------------------
public class Exam0150 {

  public static void main(String[] args) throws Exception {

    Scanner keyScan = new Scanner(System.in);

    String no;
    try (
        java.sql.Connection con = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        java.sql.Statement stmt = con.createStatement();) {

      System.out.printf("번호? ");
      no = keyScan.nextLine();

      int count;
      try {
        count = stmt.executeUpdate("delete from x_board where board_id=" + no);

        if (count > 0) {
          System.out.println("삭제하였습니다.");
        } else {
          System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        }

      } catch (Exception e) {
        System.out.println("삭제할 수 없는 번호입니다.");
      }

      keyScan.close();
    }



  }
}


