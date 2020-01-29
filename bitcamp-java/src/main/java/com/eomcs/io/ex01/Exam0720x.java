// 활용 - 지정한 폴더를 삭제하라!
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0720x {


  public static void main(String[] args) throws Exception {


    File dir = new File("temp");

    System.out.println(dir.getCanonicalPath());

  }


  static void deleteFile(File dir) {

    File[] files = dir.listFiles();

    for (File file : files) {
      if (file.isDirectory()) {
        deleteFile(file);
      } else {
        file.delete();
      }
    }
    dir.delete();
  }
}


