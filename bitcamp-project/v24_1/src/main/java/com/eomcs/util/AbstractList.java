package com.eomcs.util;


public abstract class AbstractList<E> implements List<E>{
 
  protected int size;

  public int size() {
    return size;
  }

  @Override
  public Iterator<E> iterator() {   //메소드
    // ****LinkedList에서 값을 꺼내줄 Iterator 객체를 준비하여 리턴한다.****
    // ArrayList 객체에서 Iterator 규칙에 따라 값을 꺼내주는 클래스를 정의
    //class IteratorImpl<T> implements Iterator<T> {

    
    // 위에서 정의한 Iterator 구현체를 준비한다
    //IteratorImpl<E> i = new IteratorImpl<>(this);
    
    // ArrayList에서 값을 꺼내주는 Iterator 구현체를 준비하여 리턴한다
    return new ListIterator<>(this);  
    //Iterator규칙에 따라만든 (ArrayListIterator였고 지금은 ListIterator)라서 리턴타입이 저거임
  }

}
