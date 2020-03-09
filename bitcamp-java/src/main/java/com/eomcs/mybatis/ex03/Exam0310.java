// <sql> 사용법
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Exam0310 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = //
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    // 실행 예:

    HashMap<String, Object> params = new HashMap<>();

    Scanner keyScan = new Scanner(System.in);

    System.out.print("제목? ");
    String value = keyScan.nextLine();
    params.put("title", value);

    keyScan.close();

    List<Board> boards = sqlSession.selectList("BoardMapper2.select26", params);

    // <sql> 태그를 사용하면
    // => 여러 sql문에서 중복적으로 사용하는 SQL 일부를 별도로 관리할 수 있다.
    // => 중복 SQL을 사용하여 SQL을 관리하기가 쉬워진다.

    for (Board board : boards) {
      System.out.printf("%d,  %s, %s, %s, %d\n", board.getNo(), board.getTitle(),
          board.getContent(), board.getRegisteredDate(), board.getViewCount());
    }


    sqlSession.close();
  }

}


