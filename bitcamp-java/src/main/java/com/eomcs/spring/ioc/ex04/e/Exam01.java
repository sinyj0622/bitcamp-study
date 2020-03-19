// 프로퍼티 호출 - 의존 객체 주입할 때 즉시 객체 생성하기
package com.eomcs.spring.ioc.ex04.e;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.ex04.Car;


public class Exam01 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex04/e/application-context.xml");
    System.out.println("----------------------------------");

    Car c1 = (Car) iocContainer.getBean("c1");
    Car c2 = (Car) iocContainer.getBean("c2");

    System.out.println(c1 == c2);
    System.out.println(iocContainer.getBean("c1"));
    System.out.println(iocContainer.getBean("c2"));

  }

}


