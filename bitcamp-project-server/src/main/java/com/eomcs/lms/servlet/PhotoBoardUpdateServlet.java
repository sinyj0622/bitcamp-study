package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.sql.PlatformTransactionManager;
import com.eomcs.sql.TransactionTemplate;
import com.eomcs.util.Prompt;

public class PhotoBoardUpdateServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  TransactionTemplate transactionTemplate;

  public PhotoBoardUpdateServlet(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao,
      PlatformTransactionManager txManager) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    this.transactionTemplate = new TransactionTemplate(txManager);
  }



  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    int no = Prompt.getInt(in, out, "번호? ");

    PhotoBoard old = photoBoardDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 사진 게시글이 없습니다.");
      return;
    }

    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setNo(no);
    photoBoard.setTitle(
        Prompt.getString(in, out, String.format("제목(%s)?, ", old.getTitle()), old.getTitle()));

    printPhotoFiles(out, old);
    out.println();
    out.println("사진은 일부만 변경할 수 없습니다.");
    out.println("전체를 새로 등록하세요.");

    String response = Prompt.getString(in, out, "사진을 변경하시겠습니까?(y/N) ");
    if (response.equalsIgnoreCase("y")) {
      // 사용자가 입력한 파일 목록을 PhotoBoard 객체에 저장한다.
      photoBoard.setFiles(inputPhotoFiles(in, out));
    }

    transactionTemplate.execute(() -> {
      if (photoBoardDao.update(photoBoard) == 0) {
        throw new Exception("사진 게시글 변경에 실패했습니다.");
      }

      if (photoBoard.getFiles() != null) {
        // 첨부파일을 변경한다면,
        photoFileDao.deleteAll(no);
        photoFileDao.insert(photoBoard);
      }

      out.println("사진 게시글을 변경했습니다!");
      return null;
    });

  }

  private void printPhotoFiles(PrintStream out, PhotoBoard photoBoard) throws Exception {
    out.println("사진파일:");
    List<PhotoFile> oldPhotoFiles = photoBoard.getFiles();
    for (PhotoFile photoFile : oldPhotoFiles) {
      out.printf("> %s\n", photoFile.getFilepath());
    }

  }

  private List<PhotoFile> inputPhotoFiles(Scanner in, PrintStream out) {
    // 정상적으로 등록했다면 첨부파일 입력 받는다.
    out.println("최소 한 개의 사진파일을 등록해야 합니다.");
    out.println("파일명 입력없이 그냥 엔터를 치면 파일 추가를 마칩니다..");

    ArrayList<PhotoFile> photoFiles = new ArrayList<>();
    while (true) {
      out.println("사진파일? \n!{}!");
      out.flush();
      String filepath = in.nextLine();

      if (filepath.length() == 0) {
        if (photoFiles.size() > 0) {
          break;
        } else {
          out.println("최소 한 개의 사진파일을 등록해야 합니다.");
          continue;
        }
      }

      // 1) 기본 생성자를 사용할 때,
      // PhotoFile photoFile = new PhotoFile();
      // photoFile.setFilepath(filepath);
      // photoFile.setBoardNo(photoBoard.getNo());

      // 2) 초기 값을 설정하는 생성자를 사용할 때,
      // photoFiles.add(new PhotoFile(filepath, photoBoard.getNo()));

      // 3) 셋터 메서드를 활용하여 체인 방식으로 인스턴스 필드의 값을 설정.
      photoFiles.add(new PhotoFile().setFilepath(filepath));
    }

    return photoFiles;
  }
}
