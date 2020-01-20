// HashMap과 Iterator
package com.eomcs.corelib.ex08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import com.eomcs.oop.ex08.test.E;

public class Exam0321 {
  public static void main(String[] args) {
    Member v1 = new Member("홍길동", 20);
    Member v2 = new Member("임꺽정", 30);
    Member v3 = new Member("유관순", 16);
    Member v4 = new Member("안중근", 20);
    Member v5 = new Member("윤봉길", 25);

    HashMap map = new HashMap();
    map.put("s01", v1);
    map.put("s02", v2);
    map.put("s03", v3);
    map.put("s04", v4);
    map.put("s05", v5);

    Set keys = map.keySet();
    Iterator<E> iterator = keys.iterator();
    // Iterator 객체를 생성할 때,
    // 현재 목록 객체(keys)를 바탕으로 생성한다.
    //
    // 따라서 다음과 같이 Iterator를 생성한 후에 목록의 값을 변경하면,
    // 기존 목록에서 뽑은 Iterator는 무효한 객체가 된다!!
    map.remove("s01");
    map.remove("s02");
    map.remove("s03");

    // 무효한 Iterator를 사용할 때 실행오류가 발생할 것이다.
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    // Set 객체를 통해 key 를 꺼낼 때,
    // 그 순간의 HashSet에 있는 key를 꺼낸다.
    // 즉 keySet()을 호출할 때 모든 key를 미리 목록을 만들어 리턴하지 않는다.
    /*
     * for (Object key : keys) { System.out.println(key); }
     */
  }

}


