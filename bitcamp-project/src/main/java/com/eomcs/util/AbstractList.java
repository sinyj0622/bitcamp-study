package com.eomcs.util;


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

  
  @Override
  public Iterator<E> iterator() {
    return new ListIterator<>(this);
  }
}
