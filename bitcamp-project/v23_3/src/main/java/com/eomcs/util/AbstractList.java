package com.eomcs.util;

// Generalization 3단계:
// => 추상 메서드를 선언하는 의미:
//    - 서브 클래스에 구현을 강제하는 문법.
// => 메서드 구현을 강제한다는 의미?
//    - 해당 객체가 반드시 갖춰야 할 기능을 선언하는 것.
//    - 즉 객체의 사용법(사용규칙)을 명시하는 효과.
//
// => 객체의 구현 방법에 영향을 받지 않는 메서드를 따로 분리하여
//    별도의 사용 규칙으로 정의하게 되면 
//    좀 더 유연하고 교체하기 쉬운 구조로 코드를 관리할 수 있다.
//
// 초보자를 위한 실무 공식:
// => 추상 클래스를 정의한 다음, 추상 메서드를 설정한다.
// => 추상 메서드는 인터페이스 문법을 사용하여 별도로 분리한다.
// => 클래스에서 사용 규칙(메서드 호출 규칙)을 따로 분리해서 따로 정의해 두면
//    좀 더 다양한 하위 클래스를 정의하고 다룰 수 있다.
// => 추상 메서드가 대부분인 경우 인터페이스로 정의하는 것이 낫다.
//    왜? 추상 클래스의 목적이 하위 클래스에게 공통 필드가 메서드를 상속해 주는 것인데,
//    대부분의 메서드가 추상 메서드라서 서브 클래스 입장에서 딱히 도움이 안되는 상황일때,
//    그냥 메서드 사용 규칙만 정의하는것이 코드 관리에 낫기 때문이다.
//
//

// 추상 메서드를 인터페이스로 분리했으면
// 다음과 같이 해당 인터페이스 규칙을 추가하라!!!!!!!!!!!!
// 의미
// => abstractList 를 상속받는 서브 클래스는 
//    반드시 abstractList에 추가된 규칙에 따라 메서드를 정의해야 한다
//    즉 List에 선언된 모든 추상 메서드를 반드시 구현(정의)해야 한다.
// => 구현(implement)?
//    메서드의 몸체(body)를 정의하는것
//    즉 메서드에 코드를 정의하는것
//    메서드가 해야 할 일이 무엇인지 코드를 정의하는것
//   예) abstract void m1(); < 추상메서드
//   예2) void m1 {...} < 메서드 구현
//
public abstract class AbstractList<E> implements List<E>{
  
  // List규칙에 따라 동작하는데 필요한 필드가 있다면
  // 다음과 같이 그 규칙을 따르는 클래스 쪽에 필드를 선언하면 된다.
  //
  protected int size;


  // AbstractList는 List 규칙을 포함한다.
  // List 규칙에 정의된 메서드 중에서 다음과 같이 size()를 구현한다
  // => 여기서 구현해도 되기 때문에 서브 클래스에게 구현을 맡기지 않고 여기서
  // 처리하는것이다
  //
  public int size() {
    return size;
  }

}
