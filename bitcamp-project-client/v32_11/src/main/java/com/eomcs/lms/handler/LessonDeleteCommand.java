// 사용자 입력을 받는 코드를 별도의 메소드로 분리한다.
package com.eomcs.lms.handler;

import com.eomcs.lms.dao.LessonDao;
import com.eomcs.util.Prompt;

public class LessonDeleteCommand implements Command {


  Prompt prompt;
  LessonDao lessonDao;

  public LessonDeleteCommand(LessonDao lessonDao, Prompt prompt) {
    this.lessonDao = lessonDao;
    this.prompt = prompt;
  }


  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호? ");

      lessonDao.delete(no);
      System.out.println("수업을 삭제했습니다.");
    } catch (Exception e) {
      System.out.println("삭제 실패!");
    }
  }

}
