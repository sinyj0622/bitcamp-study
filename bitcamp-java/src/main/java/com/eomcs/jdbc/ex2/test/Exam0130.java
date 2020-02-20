// 게시물 관리 - 조회
package com.eomcs.jdbc.ex2.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

// 다음과 같이 게시물을 조회하는 프로그램을 작성하라!
// ----------------------------
// 번호? 1
// 제목: aaa
// 내용: aaaaa
// 등록일: 2019-1-1
// 조회수: 2
//
// 번호? 100
// 해당 번호의 게시물이 존재하지 않습니다.
// ----------------------------
public class Exam0130 {

  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);


    String no;

    try (
        java.sql.Connection con = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        java.sql.Statement stmt = con.createStatement();) {

      System.out.printf("번호? ");
      no = keyScan.nextLine();

      ResultSet rs = stmt.executeQuery("select * from x_board where board_id=" + no);

      if (rs.next()) {
        System.out.println("번호? " + rs.getInt("board_id"));
        System.out.println("제목: " + rs.getString("title"));
        System.out.println("내용: " + rs.getString("contents"));
        System.out.println("등록일: " + rs.getDate("created_date"));
        System.out.println("조회수: " + rs.getInt("view_count"));
      } else {
        System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
      }

      keyScan.close();
    }

  }
}


