// Mybatis - SQL에 파라미터 지정하기 : #{} 의 한계
package com.eomcs.mybatis.ex02;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0220 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex02/mybatis-config05.xml");
    SqlSessionFactory factory = //
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    // 예) 파라미터로 컬럼이름을 넘겨주면
    // 해당 컬럼의 값을 오름차순으로 정렬한다.

    List<Board> list = sqlSession.selectList("BoardMapper.selectBoard1", "board_id");


    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s\n", board.getNo(), board.getTitle(), board.getContent(),
          board.getRegisteredDate());
    }

    sqlSession.close();
  }

}


