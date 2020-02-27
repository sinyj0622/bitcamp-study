package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.sql.DataSource;

public class MemberDaoImpl implements MemberDao {

  DataSource dataSource;

  public MemberDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public int insert(Member member) throws Exception {
    try (Connection con = dataSource.getConnection(); Statement stmt = con.createStatement()) {

      // DBMS에게 데이터 입력하라는 명령을 보낸다.
      // SQL 문법:
      // => insert into 테이블명(컬럼명1,컬럼명2,...) values(값1, 값2, ...)
      // => executeUpdate()의 리턴 값은 서버에 입력된 데이터의 개수이다.
      int result =
          stmt.executeUpdate("insert into lms_member(name, email, pwd, tel, photo) values('"
              + member.getName() + "' , '" + member.getEmail() + "' , '" + member.getPassword()
              + "' , '" + member.getTel() + "' , '" + member.getPhoto() + "')");
      return result;
    }
  }


  @Override
  public List<Member> findAll() throws Exception {
    try (Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();

        // MariaDB의 lms_board 테이블에 있는 데이터를 가져올 도구를 *준비*
        ResultSet rs = stmt
            .executeQuery("select member_id, name, email, pwd, cdt, tel, photo from lms_member")) {


      ArrayList<Member> list = new ArrayList<>();

      // ResultSet 도구를 사용하여 *데이터를 하나씩 가져온다.*
      while (rs.next()) { // 데이터를 한 개 가져왔으면 true를 리턴한다.
        Member member = new Member();
        member.setNo(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setPassword(rs.getString("pwd"));
        member.setRegisteredDate(rs.getDate("cdt"));
        member.setTel(rs.getString("tel"));
        member.setPhoto(rs.getString("photo"));

        list.add(member);
      }

      return list;

    }
  }

  @Override
  public Member findByNo(int no) throws Exception {
    try (Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();

        // MariaDB의 lms_board 테이블에 있는 데이터를 가져올 도구를 *준비*
        ResultSet rs = stmt.executeQuery("select member_id, name, email, pwd, cdt, tel, photo "
            + "from lms_member where member_id=" + no)) {

      // ResultSet 도구를 사용하여 *데이터를 하나씩 가져온다.*
      if (rs.next()) { // 데이터를 한 개 가져왔으면 true를 리턴한다.
        Member member = new Member();
        member.setNo(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setPassword(rs.getString("pwd"));
        member.setRegisteredDate(rs.getDate("cdt"));
        member.setTel(rs.getString("tel"));
        member.setPhoto(rs.getString("photo"));

        return member;
      } else {
        return null;
      }

    }

  }

  @Override
  public int update(Member member) throws Exception {
    try (Connection con = dataSource.getConnection(); Statement stmt = con.createStatement()) {

      int result =
          stmt.executeUpdate("update lms_member set name= '" + member.getName() + "', email='"
              + member.getEmail() + "', pwd='" + member.getPassword() + "', tel='" + member.getTel()
              + "', photo='" + member.getPhoto() + "' where member_id=" + member.getNo());

      return result;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (Connection con = dataSource.getConnection(); Statement stmt = con.createStatement()) {

      // DBMS에게 데이터를 변경하라는 명령을 보낸다
      // SQL 문법
      // delete from 테이블명 where 조건
      // =>executeUpdate()의 리턴 값은 SQL 명령에 따라 변경된 데이터의 개수이다.
      int result = stmt.executeUpdate("delete from lms_member where member_id=" + no);
      return result;
    }
  }


  @Override
  public List<Member> findByKeyword(String keyword) throws Exception {
    try (Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();

        // MariaDB의 lms_board 테이블에 있는 데이터를 가져올 도구를 *준비*
        ResultSet rs = stmt.executeQuery("select member_id, name, email, pwd, cdt, tel, photo" //
            + " from lms_member"//
            + " where name like '%" + keyword //
            + "%' or email like '%" + keyword //
            + "%' or tel like '%" + keyword + "%'")) {


      ArrayList<Member> list = new ArrayList<>();

      // ResultSet 도구를 사용하여 *데이터를 하나씩 가져온다.*
      while (rs.next()) { // 데이터를 한 개 가져왔으면 true를 리턴한다.
        Member member = new Member();
        member.setNo(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setPassword(rs.getString("pwd"));
        member.setRegisteredDate(rs.getDate("cdt"));
        member.setTel(rs.getString("tel"));
        member.setPhoto(rs.getString("photo"));

        list.add(member);
      }

      return list;

    }
  }

}
