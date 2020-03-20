// 의존 객체 주입 자동화하기 - 같은 타입의 의존 객체가 여러개 있을 때; @Qualifier 애노테이션
package com.eomcs.spring.ioc.ex08.h;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam01 {

  public static void main(String[] args) {

    // 같은 타입의 의존 객체가 여러 개 있을 때
    // 그 중 어떤 객체를 주입해야 할 지 알 수 없기 때문에
    // Spring IoC 컨테이너는 예외를 발생시킨다.
    //
    // 해결책?
    // => @Qualifier 애노테이션을 사용하여 주입할 객체를 지정한다.

    // 주의!
    // => AutowiredAnnotationBeanPostProcessor는 @Qualifier 애노테이션을 처리하지 못한다
    // => 따라서 @qualifier 애노테이션을 처리할 BeanPostProcessor를 따로 등록해야 한다
    //
    //
    // 같은 타입의 객체가 여러 개 있다 하더라도 그 중에 지정된 이름을 갖는 객체가 주입된다.
    // 그러나, 막상 실행을 하면 Engine 객체가 여러 개 있다고 실행 오류가 발생한다.
    // 이유는?
    // => @Qualifier 애노테이션을 처리할 BeanPostProcessor가 없기 때문이다.
    // 해결책?
    // => @Qualifier 애노테이션을 처리할 BeanPostProcessor를 등록하면 된다.
    //
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex08/h/application-context.xml");

    // Spring IoC 컨테이너에 들어있는 객체
    SpringUtils.printBeanList(iocContainer);
    // Car 객체를 꺼내 Engine 객체가 주입되었는지 확인해보자!
    System.out.println(iocContainer.getBean("c1"));
  }

}


