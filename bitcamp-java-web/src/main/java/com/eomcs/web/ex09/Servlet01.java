// (공통)보관소에 값 넣기
package com.eomcs.web.ex09;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex09/s1")
@SuppressWarnings("serial")
public class Servlet01 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 테스트 방법:
    // => http://localhost:8080/java-web/ex09/s1
    //

    // 1) ServletContext 보관소에 값 넣기 - 공통으로 사용할 데이터
    // => ServletContext 객체는 웹 애플리케이션이 시작될 때 생성된다.
    ServletContext sc = this.getServletContext();
    sc.setAttribute("v1", "aaa");

    // (클라이언트가 최초로 접속하게되면)
    // 2) HttpSession 보관소에 값 넣기 - 특정사용자만 사용할 데이터
    // => HttpSession 객체는 웹 브라우저에서
    // '세션 아이디(예:고객번호, 스탬프 카드)'를 제공하지 않으면,
    // getSession()을 호출할 때 생성된다.
    // 즉 이 요청을 한 클라이언트의 HttpSession 객체가 없다면 만들어준다.
    // => 웹 브라우저에서 '세션 아이디'를 제공하면,
    // getSession()을 호출할 때 기존에 생성했던 세션 객체를 리턴한다.
    // 즉 이미 이 클라이언트를 위해 만든 객체가 있다면 그 객체를 리턴한다.
    HttpSession session = request.getSession();
    session.setAttribute("v2", "bbb");

    // 3) ServletRequest 보관소에 값 넣기 - 서블릿끼리 처리할 데이터, 요청처리 데이터
    // => ServletRequest 객체는 클라이언트가 요청할 때마다 생성된다.
    request.setAttribute("v3", "ccc");

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("보관소에 값을 넣었습니다. - /ex09/s1");


    // 4) 특정 JSP 에서 사용할 데이터라면 pageContext 저장소

  }
}

