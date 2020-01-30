// 부품 연결 예 : FileInputStresam ---> DataInputStream
package com.eomcs.io.ex08;

import java.io.FileInputStream;

public class Exam0320 {

  public static void main(String[] args) throws Exception {

    FileInputStream fileIn = new FileInputStream("temp/test7.data");
    DataInputStream in = new DataInputStream(fileIn);

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


