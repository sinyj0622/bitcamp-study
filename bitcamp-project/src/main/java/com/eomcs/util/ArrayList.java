package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {

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


  @SuppressWarnings({"unchecked"})
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
      return (E[]) Arrays.copyOf(this.list, this.size, arr.getClass()); //무조건 새배열을 만들어 리턴
    }
    System.arraycopy(this.list, 0, arr, 0, this.size); //arr 갯수만큼만 복사한다

    /*
     //위의 arraycopy()는 다음 코드와 같다.
    for (int i = 0; i < this.size
    qi; i++) {
      arr[i] = (E) this.list[i];  //arr방에 복사
    }*/

    return arr;

    // copyOf() 메서드야 
    // arrayType에 지정된 배열을 size 만큼 만들어라.
    // 그리고 list 배열에 저장된 주소를 새로만든 배열에 복사하라.
    // 마지막으로 새로 만든 배열의 주소를 리턴하라!!!
    //return (E[]) Arrays.copyOf(this.list, this.size, arrayType);  
  } // 보드클래스 배열의 정보를 넘겨 size에 맞게 자르고 list에 저장해라
  //E는 배열을 만들수가 없기 때문에 배열타입을 받아 이런방법을 사용한다



  public void add(E obj) {
    if (this.size == this.list.length) {
      // 현재 배열에 게시글 객체가 꽉 찼으면, 배열을 늘린다.
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = obj;
  }

  @SuppressWarnings("unchecked")
  public E get(int idx) {
    if (idx >= 0 && idx < this.size) {
      return (E)this.list[idx];
    } else {
      return null;
    }
  }

  @SuppressWarnings("unchecked")
  public E set(int index, E obj) {
    if (index < 0 || index >= this.size) 
      return null;

    E old = (E) this.list[index];
    this.list[index] = obj; //obj 값으로 넣겠다..는말

    return old;
  }

  public E remove(int index) {
    if (index < 0 || index >= this.size) 
      return null;

    // 삭제할 항목을 따로 보관해둔다
    E old = (E) this.list[index];


    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }

    this.size--;

    this.list[this.size] = null;

    // 삭제한 항목을 리턴한다.
    return old;
  }

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add("eee");
    list.add("fff");

    list.remove(6);
    /*
    list.set(0, "0000");
    list.set(3, "3333");
    list.set(5, "5555");
    list.set(-1, "ㅋㅋㅋ");
    list.set(6, "^^^");
*/
    String[] arr = list.toArray(new String[] {});
    for (String s : arr) {
      System.out.println(s);
    }
  }

  public int size() {
    return this.size;
  }
}










