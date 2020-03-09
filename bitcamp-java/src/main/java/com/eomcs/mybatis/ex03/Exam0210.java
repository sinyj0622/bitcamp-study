// 다이나믹 SQL 다루기 - <choose> 사용법
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0210 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = //
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    // dynamic sql?
    // => 조건에 따라 sql을 달리 생성하는 것
    // => mybatis는 이를 위해 조건에 따라 SQL 을 변경하거나
    // 동일한 SQL을 반복적으로 생성할 수 있는 문법을 제공한다

    // 실행 예:
    // => 사용자로부터 검색 키워드를 입력 받아 조회한다.
    // => 제목, 내용, 번호로 검색하기
    //

    Scanner keyScan = new Scanner(System.in);
    System.out.print("항목(1:번호, 2:제목, 그 외:내용)? ");
    String item = keyScan.nextLine();

    System.out.print("검색어? ");
    String keyword = keyScan.nextLine();

    keyScan.close();

    // SQL 매퍼에 해쉬맵으로 여러개의 값을 넘긴다
    HashMap<String, Object> params = new HashMap<>();
    if (item.equals("1")) {
      params.put("item", "no");
    } else if (item.equals("2")) {
      params.put("item", "title");
    } else {
      params.put("item", "content");
    }
    params.put("keyword", keyword);

    List<Board> list = null;

    list = sqlSession.selectList("BoardMapper.select21", params);


    for (Board board : list) {
      System.out.printf("%d,  %s, %s, %s, %d\n", board.getNo(), board.getTitle(),
          board.getContent(), board.getRegisteredDate(), board.getViewCount());
    }

    sqlSession.close();
  }

}


