package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {
  Object[] elementDate;
  int size;

  static final int DEFAULT_CAPACITY = 100;

  public ArrayList() {
    this.elementDate = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementDate = new Object[DEFAULT_CAPACITY];
    }
    this.elementDate = new Object[initialCapacity];
  }

  public void add(E e) {
    if (this.elementDate.length == this.size) {
      int oldSize = this.elementDate.length;
      int newSize = oldSize + (oldSize >> 1);

      Object[] arr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        arr[i] = this.elementDate[i];
      }
    }
    this.elementDate[size++] = e;
  }

  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return (E) this.elementDate[index];
  }

  public E set(int index, Object e) {    
    if (index < 0 || index >= this.size) {
      return null;
    }
    Object oldValue = this.elementDate[index];
    this.elementDate[index] = e;
    return (E)oldValue;
  }

  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    Object oldValue = this.elementDate[index];
    for (int i = index + 1; i < this.size; i++) {
      this.elementDate[i - 1] = this.elementDate[i];
    }
    this.size--;
    return (E) oldValue;
  }
  
  public int size() {
    return this.size;
  }
  
  public E[] toArray() {
    return (E[]) Arrays.copyOf(this.elementDate, this.size);
  }
  
  public E[] toArray(E[] arr) {
    return (E[]) Arrays.copyOf(this.elementDate, this.size, arr.getClass());
  }
  
}
