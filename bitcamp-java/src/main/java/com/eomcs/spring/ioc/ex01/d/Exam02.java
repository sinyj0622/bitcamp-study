// 스프링 IoC 컨테이너에 보관된 객체를 확인하기
package com.eomcs.spring.ioc.ex01.d;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam02 {
  public static void main(String[] args) {


    // 3) 자바 클래스 파일의 애노테이션으로부터 설정 정보를 추출한다.
    // => 자바 클래스로 설정 정보를 다루는 것을 'java config' 라 부른다.
    // => 생성자 파라미터로 java config 클래스의 타입 정보를 넘긴다.
    ApplicationContext iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);


    // 현재 IoC 컨테이너에 들어 있는 객체를 출력해보자
    SpringUtils.printBeanList(iocContainer);

    // AnnotationConfigApplicationContext
    // 애노테이션 처리에 필요한 도구를 기본 포함하고 있다.
    // 또한 java config 클래스(AppConfig)의 객체도 포함한다.


    System.out.println("실행 완료!");
  }
}


