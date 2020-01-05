package com.eomcs.lms.handler;

import java.util.Arrays;

import com.eomcs.lms.domain.Board;

public class ArrayList {
	static final int DEFAULT_CAPACITY = 3;
	  
	  Object[] list;
	  int size = 0;
	  
	  public ArrayList() {
	    this.list = new Object[DEFAULT_CAPACITY];
	  }
	  
	  public ArrayList(int capacity) {
	    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
	      this.list = new Object[DEFAULT_CAPACITY];
	    else 
	      this.list = new Object[capacity];
	  }

	  public Object[] toArray() {
	    /*
	    Board[] arr = new Board[this.size];
	    for (int i = 0; i < this.size; i++) {
	      arr[i] = this.list[i];
	    }
	    return arr;
	    */
	    return Arrays.copyOf(this.list, this.size);
	  }

	  public void add(Object object) {
	    if (this.size == this.list.length) {
	      // 현재 배열에 게시글 객체가 꽉 찼으면, 배열을 늘린다.
	      int oldCapacity = this.list.length;
	      int newCapacity = oldCapacity + (oldCapacity >> 1);
	      /*
	      Board[] arr = new Board[newCapacity];
	      for (int i = 0; i < this.list.length; i++) {
	        arr[i] = this.list[i];
	      }
	      this.list = arr;
	      */
	      this.list = Arrays.copyOf(this.list, newCapacity);
	      System.out.printf("새 배열을 %d 개 생성하였음!", newCapacity);
	    }
	    this.list[this.size++] = object;
	  }
	  
	  public Object get(int idx) {
	      if (idx > 0 && idx < this.size) {
	        return this.list[idx];
	        } else {
	    return null;
	        }
	  }
}
