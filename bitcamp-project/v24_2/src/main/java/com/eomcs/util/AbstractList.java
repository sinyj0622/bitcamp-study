package com.eomcs.util;


public abstract class AbstractList<E> implements List<E>{

  protected int size;

  public int size() {
    return size;
  }
  
  

  @Override
  public Iterator<E> iterator() {   //메소드
  
    // ****LinkedList에서 값을 꺼내줄 Iterator 객체를 준비하여 리턴한다.****
    return this.new ListIterator<E>();  //new ListIterator<E>(); this 생략가능
    // 이너클래스의 객체를 만드려면 바깥클래스의 주소가 있어야한다(non-static class의 경우)
  }
  
  
    
  
  
    //non-static nested class = **inner class**
    class ListIterator<T> implements Iterator<T> {

    List<T> list;  //어레이주소를 받아야함
    int cursor; //가리키는것

    
    @SuppressWarnings("unchecked")
    public ListIterator() {
      this.list = (List<T>) AbstractList.this;  //그냥 this는 ListIterator 주소..
    }


    @Override
    public boolean hasNext() {
      return cursor < list.size();
    }

    @Override
    public T next() {
      return list.get(cursor++);
    }
  }


}
