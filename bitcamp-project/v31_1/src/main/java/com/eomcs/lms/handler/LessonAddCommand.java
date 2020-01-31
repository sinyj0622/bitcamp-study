// 사용자 입력을 받는 코드를 별도의 메소드로 분리한다.
package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonAddCommand implements Command {


  List<Lesson> lessonList;

  public Prompt prompt;

  public LessonAddCommand(Prompt prompt, List<Lesson> list) {
    this.prompt = prompt;
    this.lessonList = list;
  }

  @Override
  public void execute() {
    Lesson lesson = new Lesson();

    lesson.setNo(prompt.inputInt("번호? "));
    lesson.setTitle(prompt.inputString("수업명? "));
    lesson.setDescription(prompt.inputString("설명? "));
    lesson.setStartDate(prompt.inputDate("시작일? "));
    lesson.setEndDate(prompt.inputDate("종료일? "));
    lesson.setTotalHours(prompt.inputInt("총수업시간? "));
    lesson.setDayHours(prompt.inputInt("일수업시간? "));

    lessonList.add(lesson);

    System.out.println("저장하였습니다.");
  }



}
