package com.eomcs.util;


//ArrayList 객체에서 Iterator 규칙에 따라 값을 꺼내주는 클래스를 정의
public class ListIterator<E> implements Iterator {
  
  
  List<E> list;  //어레이주소를 받아야함
  int cursor; //가리키는것
  
  public ListIterator(List<E> list) {
    this.list = list;
  }
  
  
  @Override
  public boolean hasNext() {
    return cursor < list.size();
  }
  
  @Override
  public E next() {
    return list.get(cursor++);
  }
  
  
}

