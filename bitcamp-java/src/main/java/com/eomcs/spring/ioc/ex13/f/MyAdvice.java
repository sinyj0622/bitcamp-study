// 특정 메서드 호출 전후에 실행되는 클래스
package com.eomcs.spring.ioc.ex13.f;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Advice 객체를 IoC 컨테이너에 등록해야 한다.
@Component

// 이 객체가 AOP Advice를 설정하는 객체임을 표시한다.
@Aspect
public class MyAdvice {

  // XML 설정 예:
  /*
   * <aop:before pointcut="execution(* com.eomcs.spring.ioc.ex13.e.X.*(..)) and args(a,b)"
   * method="doBefore"/>
   */
  @Before("execution(* com.eomcs.spring.ioc.ex13.f.X.*(..)) and args(a,b)")
  public void doBefore(int a, int b) {
    System.out.printf("MyAdvice.doBefore(): %d, %d\n", a, b);
  }



  // 타겟 객체의 메서드를 호출한 후 그 결과를 받기
  // => 설정 파일에 정의된 이름을 사용하여 파라미터를 선언해야 한다.
  // XML 설정 예:
  /*
   * <aop:after-returning pointcut="execution(* com.eomcs.spring.ioc.ex13.e.X.*(..))"
   * method="doAfterReturning" returning="returnValue"/>
   */
  @AfterReturning(pointcut = "execution(* com.eomcs.spring.ioc.ex13.f.X.*(..))",
      returning = "returnValue")
  public void doAfterReturning(Object returnValue) {
    System.out.printf("MyAdvice.doAfterReturning(): %d\n", returnValue);
  }



  // 타겟 객체의 메서드를 호출할 때 예외가 발생했다면 그 예외 객체를 받기
  // => 설정 파일에 정의된 이름을 사용하여 파라미터를 선언해야 한다.
  // XML 설정 예:
  /*
   * <aop:after-throwing pointcut="execution(* com.eomcs.spring.ioc.ex13.e.X.*(..))"
   * method="doAfterThrowing" throwing="error"/>
   */
  @AfterThrowing(pointcut = "execution(* com.eomcs.spring.ioc.ex13.f.X.*(..))", throwing = "error")
  public void doAfterThrowing(Exception error) {
    System.out.printf("MyAdvice.doAfterThrowing(): %s\n", error.getMessage());
  }
}


