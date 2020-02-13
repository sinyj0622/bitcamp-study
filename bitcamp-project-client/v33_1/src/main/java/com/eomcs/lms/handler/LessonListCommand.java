// 사용자 입력을 받는 코드를 별도의 메소드로 분리한다.
package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {

  LessonDao lessonDao;

  public LessonListCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {
    try {

      List<Lesson> lessons = lessonDao.findAll();
      for (Lesson l : lessons) {
        System.out.printf("%d, %s, %s ~ %s, %d\n", l.getNo(), l.getTitle(), l.getStartDate(),
            l.getEndDate(), l.getTotalHours());
      }
    } catch (Exception e) {
      System.out.println("목록 조회 실패!");
    }
  }



}
