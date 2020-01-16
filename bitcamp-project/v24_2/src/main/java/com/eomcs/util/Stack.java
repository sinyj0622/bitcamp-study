package com.eomcs.util;

import java.util.Arrays;

public class Stack<E> implements Cloneable{

  private static final int DEFAULT_CAPCITY = 10;

  Object[] elementData;
  int size;

  public Stack() {
    this.elementData = new Object[DEFAULT_CAPCITY];
    this.size = 0;
  }

  public void push(E value) {
    if (size == elementData.length) {
      grow();
    }
    this.elementData[size++] = value;
  }

  private void grow() {
    this.elementData = Arrays.copyOf(elementData, newCapacity());
  }

  private int newCapacity() {
    int oldCapacity = this.elementData.length;
    return oldCapacity + (oldCapacity >> 1);
  }

  @SuppressWarnings("unchecked")
  public E pop() {
    if (this.empty())
      return null;
    E value = (E)this.elementData[--this.size];
    this.elementData[this.size] = null; //꺼낸주소를 null로 만듬
    return value;
  }

  public boolean empty() {
    return this.size == 0;
  }
  // Object.clone()의 'shallow copy'이용하여 스택 객체 복사하기
  //=> 객체의 인스턴스 변수를 그대로 복제한다.
  //=> 인스턴스 변수가 가리키는 객체는 복제하지 않는다.
  //
  // 문제점?
  //=> 따라서 인스턴스 변수인 elementData가 가리키는 배열을 복제하지 않는다
  //=> 그래서 배열의 값을 바꾸면 원본 스택에도 영향을 끼친다.
  /* 
   * 
 @Override
 public Stack clone() {
   try {
  return (Stack)super.clone();
   } catch (CloneNotSupportedException ex) {
     // object의 clone() 메서드는 복제가 허용된 객체에 대해서만 해당 인스턴스 변수를 복제한다.
     // 복제가 허용되지 않은 객체에 대해서 clone()을 호출하면
     // CloneNotSupportedException 실행오류가 발생한다.
     // 해결책?
     //  => 해당 클래스의 객체를 복제 할 수 있음을 표시하라.
     // => 방법 : cloneable 인터페이스를 지정해야 한다.
     //     예) class MY implements Cloneable{...}
     System.out.println(ex);
     return null;
   }
}
   */

  // deep copy를 이용하여 객체 복사하기
  // => 데이터가 들어있는 배열도 그대로 복제한다.
  // => 따라서 배열의 값을 바꾸더라도 원본 객체에 영향을 끼치지 않는다.
  //
  @SuppressWarnings("unchecked")
  @Override
  public Stack<E> clone() {
    try {
    // 1) shallow copy를 통해 '이 객체의 인스턴스 변수'는 그대로 복제한다
    Stack<E> temp = (Stack<E>) super.clone();
    
    //2) elementData 배열을 복제
    // => 배열만 복제하고 배열에 저장된 객체(ex: 문자열,member객체)까지는 복제하지 않는다
    // => 어디까지 복제(deep copy의 수준)할 것인지는 상황에 따라 결정한다.
    //
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    
    //3) 복제한 스택 객체가 새로 만든 배열을 가리키도록 한다
    temp.elementData = arr;
    
    return temp;
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }

  
  public Iterator<E> iterator() {
    // this = 인스턴스 주소;
    // inner class를 생성하려면 바깥 클래스의 인스턴스 주소를 앞쪽에 줘야한다
    return this.new StackIterator<E>();
  }
  
  
    //non-static class = inner class
    class StackIterator<T> implements Iterator<T> {
    Stack<T> stack;  
    
    @SuppressWarnings("unchecked")
    public StackIterator() {
      this.stack = (Stack<T>) Stack.this.clone();
    }
    
    @Override
    public boolean hasNext() {
      return !stack.empty();
    }
    
    @Override
    public T next() {
      return stack.pop();
    }
  }
  
  
}
