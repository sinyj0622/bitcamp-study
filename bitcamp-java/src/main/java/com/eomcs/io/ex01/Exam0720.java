// 활용 - 지정한 폴더를 삭제하라!
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0720 {


  public static void main(String[] args) throws Exception {



    // temp 디렉 토리를 삭제하기
    File dir = new File("temp");

    deleteFile(dir);

    System.out.println("삭제하였습니다!");
  }

  static void deleteFile(File dir) {
    File[] files = dir.listFiles();

    for (File file : files) {
      if (file.isDirectory()) {
        deleteFile(file); // 하위 디렉토리
      } else {
        file.delete();
      }
    }
    dir.delete(); // 자신 디렉토리
  }


}


