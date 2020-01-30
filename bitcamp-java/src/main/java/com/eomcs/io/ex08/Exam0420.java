// 부품 연결 예 : FileInputStresam ---> BufferedInputStream --> DataInputStream
package com.eomcs.io.ex08;

import java.io.FileInputStream;

public class Exam0420 {

  public static void main(String[] args) throws Exception {

    FileInputStream fileIn = new FileInputStream("temp/test7.data");

    // 데코레이터 패턴의 장점은
    // 다음과 같이 필요한 기능을 쉽게 삽일할 수 있다는것이다.
    // 필요하면 붙이고, 필요없으면 쉽게 뗄 수 있다.
    BufferedInputStream bufIn = new BufferedInputStream(fileIn);

    DataInputStream in = new DataInputStream(bufIn);

    Member member = new Member();

    long start = System.currentTimeMillis();

    for (int i = 0; i < 100000; i++) {
      member.name = in.readUTF();
      member.age = in.readInt();
      member.gender = in.readBoolean();
    }

    long end = System.currentTimeMillis();

    in.close();

    System.out.printf("%s\n", member);

    System.out.println(end - start);
  }
}


