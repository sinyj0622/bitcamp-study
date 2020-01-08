package com.eomcs.util;

public class ArrayListTest {

  public static void main(String[] args) {
    
    ArrayList<String> a1 = new ArrayList<>();
    
    
    a1.add("aaa");
    a1.add("bbb");
    a1.add("ccc");
    a1.add("ddd");
    a1.add("eee");
    a1.add("fff");
    //a1.add(new Member()); //컴파일오류
  
    System.out.println(a1.get(-1));
    System.out.println(a1.get(6));
    
    
    System.out.println("--------------");
    
    String oldValue = a1.set(0, "xxx");
    
    System.out.printf("%s ==> %s\n", oldValue, a1.get(0));
    
    a1.set(-1, "yyy");
    a1.set(6, "zzz");
    
    print(a1);

    System.out.println(a1.get(2));
    
    a1.remove(-1);
    
    oldValue = a1.remove(5);
    System.out.printf("삭제전(%s) ==> 삭제후(%s)\n", oldValue, a1.get(0));
    
    System.out.println("--------------");
    
    print(a1);
  }

  
  static void print(ArrayList<String> arr) {
    String[] list = arr.toArray(new String[] {});
    for (String e : list) {
      System.out.println(e);
    }
  }
}
