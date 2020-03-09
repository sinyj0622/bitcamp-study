// 다이나믹 SQL 다루기 - <foreach> 사용 전
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0240 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = //
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    // 실행 예:

    HashMap<String, Object> params = new HashMap<>();

    Scanner keyScan = new Scanner(System.in);

    System.out.print("조회할 게시물 번호들(예: 1 6 8 10; 최대 5개)? ");
    String[] values = keyScan.nextLine().split(" ");

    int index = 0;
    for (String value : values) {
      params.put("no" + index++, value);
    }

    keyScan.close();

    List<Board> boards = sqlSession.selectList("BoardMapper.select22", params);

    for (Board board : boards) {
      System.out.printf("%d,  %s, %s, %s, %d\n", board.getNo(), board.getTitle(),
          board.getContent(), board.getRegisteredDate(), board.getViewCount());
    }


    sqlSession.close();
  }

}


