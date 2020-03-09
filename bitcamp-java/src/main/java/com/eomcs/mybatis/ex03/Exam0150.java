// 다이나믹 SQL 다루기 - <where> 사용 전: 조건이 빠졌을때 문제 발생 해결책
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0150 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = //
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();


    // 실행 예:
    // => 복합 검색하기

    // SQL 매퍼에 해쉬맵으로 여러개의 값을 넘긴다
    HashMap<String, Object> params = new HashMap<>();

    Scanner keyScan = new Scanner(System.in);

    System.out.print("번호? ");
    String value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("no", value);
    }

    System.out.print("제목? ");
    value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("title", value);
    }

    System.out.print("내용? ");
    value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("content", value);
    }

    keyScan.close();


    List<Board> list = sqlSession.selectList("BoardMapper.select6", params);

    // 문제점
    // => no값이 없을경우 잘못된 sql문을 생성한다

    for (Board board : list) {
      System.out.printf("%d,  %s, %s, %s, %d\n", board.getNo(), board.getTitle(),
          board.getContent(), board.getRegisteredDate(), board.getViewCount());
    }

    sqlSession.close();
  }

}


