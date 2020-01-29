// 활용 - 지정한 폴더 및 그 하위 폴더까지 모두 검색하여 파일 및 디렉토리 이름을 출력하라.
package com.eomcs.io.ex01;

import java.io.File;
import java.io.IOException;

public class Exam0710x {


  public static void main(String[] args) throws IOException {


    File dir = new File(".");

    System.out.println(dir.getCanonicalPath());

    printList(dir, 1);

  }

  static void printList(File dir, int level) {

    File[] files = dir.listFiles();

    for (File file : files) {
      for (int i = 0; i < level; i++) {
        System.out.print("  ");
      }
      if (file.isDirectory()) {
        System.out.printf("%s//\n", file.getName());
        printList(file, level + 1);
      } else {
        System.out.printf("\\--%s\n", file.getName());
      }
    }

  }

}


