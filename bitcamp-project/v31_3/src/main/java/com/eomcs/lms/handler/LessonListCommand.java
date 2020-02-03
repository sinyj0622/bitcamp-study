// 사용자 입력을 받는 코드를 별도의 메소드로 분리한다.
package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonListCommand implements Command {


  List<Lesson> lessonList;

  public Prompt prompt;

  public LessonListCommand(List<Lesson> list) {
    this.lessonList = list;
  }


  @Override
  public void execute() {
    for (int i = 0; i < lessonList.size(); i++) {
      Lesson l = lessonList.get(i);
      System.out.printf("%d, %s, %s ~ %s, %d\n", l.getNo(), l.getTitle(), l.getStartDate(),
          l.getEndDate(), l.getTotalHours());
    }
  }



}
