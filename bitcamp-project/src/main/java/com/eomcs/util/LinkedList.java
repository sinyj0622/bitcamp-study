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
    if (index < 0 || index >= size) 
      return null;
    
    Node cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    return cursor.value;
    
  }
  
  public void add(int index, Object value) {
    if (index < 0 || index >= size) 
      return;
    
    Node newNode = new Node();
    newNode.value = value;
    

    Node cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
     newNode.next = cursor.next;
     
    }
    
  }
  
  
  static class Node {
    Object value;
    Node next;
  }
  

}
