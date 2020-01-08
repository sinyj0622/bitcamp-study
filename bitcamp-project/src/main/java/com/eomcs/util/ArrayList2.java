package com.eomcs.util;

import java.util.Arrays;

public class ArrayList2<E> {
  Object[] elementData;
  int size;
  
  private static final int DEFAULT_CAPACITY = 100;
  
  public ArrayList2() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList2(int initialCapacity) {
    if (this.size < this.DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    }
    this.elementData = new Object[initialCapacity];
  }
  
  
  public void add(E e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
      */
    }
    this.elementData[size++] = e;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index > this.size) {
      return null;
    }
    return (E) this.elementData[index];
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, Object e) {    
    if (index < 0 || index > this.size) {
    return null;
  }
    E oldValue = (E) this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index){
    if (index < 0 || index >= this.size) {
      return null;
    }
    E oldValue = (E) this.elementData[index];
    System.arraycopy(this.elementData, index + 1, this.elementData, //index + 1를 index자리로 땡겨오고 전체배열에서 인덱스+1부터 복사
       index, this.size - (index + 1) );
    /*for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    */
    this.size--;
    return oldValue;
  }
  
  public int size() {
    return this.size();
  }
  
  public Object[] toArray() {
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    return arr;
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass());

  }


  
  
  
}
