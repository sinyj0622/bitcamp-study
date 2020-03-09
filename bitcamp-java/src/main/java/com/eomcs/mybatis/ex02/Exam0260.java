// Mybatis - DELETE SQL 실행하기
package com.eomcs.mybatis.ex02;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0260 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex02/mybatis-config09.xml");
    SqlSessionFactory factory = //
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    int count = sqlSession.delete("BoardMapper.deleteBoardFile", 40);
    int count2 = sqlSession.delete("BoardMapper.deleteBoard", 40);
    System.out.println(count2);
    sqlSession.commit();
    // commit 명령을 내리지 않으면 insert/update/delete을 테이블에 반영하지 않는다.
    // close() 할 때 취소된다.

    // 용어 정리!
    // commit : 임시 메모리에 저장된 작업 결과를 실제 테이블에 반영시키는 명령
    // rollback : 임시 메모리에 저장된 작업 결과를 취소하는 명령

    sqlSession.close();
  }

}


