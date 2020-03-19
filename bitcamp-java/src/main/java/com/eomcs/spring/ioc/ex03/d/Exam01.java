// 생성자 호출
package com.eomcs.spring.ioc.ex03.d;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam01 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex03/d/application-context.xml");

    SpringUtils.printBeanNames(iocContainer);
  }

}


