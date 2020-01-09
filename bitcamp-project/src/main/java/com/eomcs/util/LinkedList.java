package com.eomcs.util;

public class LinkedList {
  
  Node first;
  Node last;
  int size;
  
  public void add(Object value) {
    Node newNode = new Node();
    newNode.value = value;
    
    if (first == null) {
     last = first = newNode;
    } else {
     last.next = newNode;
     last = newNode;
    }
    
    this.size++;
  }
  
  public Object get(int index) {
    if (index < 0 || index > this.size) 
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index; i++) {
     cursor = cursor.next;
    }
    
    return cursor.value;
  }
  
  public void add(int index, Object value) {
    if (index < 0 || index > this.size) 
    return;
    
    Node newNode = new Node();
    newNode.value = value;
    
    Node cursor = first;
    for (int i = 0; i < index - 1; i++) {
      newNode.next = cursor.next;
      cursor.next = newNode;
    }
    
    this.size++;
  }
  
  public Object set(int index, Object value) {
    if (index < 0 || index > this.size) 
    return null;
    
    Node cursor = first;
    for (int i = 0; i < index; i++) {
     cursor = cursor.next;
    }
    
    Object oldValue = cursor.value;
    cursor.value = value;
    
    return oldValue;
    
  }
  
  public Object[] toArray() {
    Object[] arr = new Object[size];
    
    Node cursor = first;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
       cursor = cursor.next;
    }
    
    return arr;
  }
  
  public class Node {
    
    Object value;
    Node next;
    
}
}
