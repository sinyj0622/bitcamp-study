package com.eomcs.util;


public abstract class AbstractList<E> implements List<E>{

  protected int size;

  public int size() {
    return size;
  }
  
  
  
  

  @Override
  public Iterator<E> iterator() {
    
  // lacal class : 특정 메서드 안에서만 사용하는 중첩클래스라면 그 메서드 안에 둔다.
    class ListIterator<T> implements Iterator<T> {
     
    List<T> list;  
    int cursor; 

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
  
    // 로컬 클래스는 인스턴스 멤버가 아니기 때문에
    // 앞쪽에 인스턴스 주소를 전달해서는 안된다.
    // 즉 this.을 붙여서는 안된다.
    return new ListIterator<E>();  // this를 생략한게 아님
   
  }
  
  
    
  
  
    


}
