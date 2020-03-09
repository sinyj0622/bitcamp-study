// 다이나믹 SQL 다루기 - <foreach> 사용법 3
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Exam0270 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = //
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    // 실행 예:

    HashMap<String, Object> params = new HashMap<>();

    Scanner keyScan = new Scanner(System.in);

    System.out.print("검색? ");
    String[] values = keyScan.nextLine().split(" ");

    ArrayList<Object> words = new ArrayList<>();
    for (String value : values) {
      words.add(value.trim());
    }
    params.put("words", words);

    keyScan.close();

    List<Board> boards = sqlSession.selectList("BoardMapper.select25", params);

    for (Board board : boards) {
      System.out.printf("%d,  %s, %s, %s, %d\n", board.getNo(), board.getTitle(),
          board.getContent(), board.getRegisteredDate(), board.getViewCount());
    }


    sqlSession.close();
  }

}


