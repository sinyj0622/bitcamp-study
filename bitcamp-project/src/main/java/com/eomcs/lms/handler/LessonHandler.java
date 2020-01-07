package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;

public class LessonHandler {
  
  ArrayList<Lesson> lessonList;
  
  public Scanner input;
  
  public LessonHandler(Scanner input) {
    this.input = input;
    this.lessonList = new ArrayList<>();
  }
  
  public void addLesson() {
    Lesson lesson = new Lesson();
    
    System.out.print("번호? ");
    lesson.setNo(input.nextInt());

    input.nextLine(); 

    System.out.print("수업명? ");
    lesson.setTitle(input.nextLine());

    System.out.print("설명? ");
    lesson.setDescription(input.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(input.next()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(input.next()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(input.nextInt());

    System.out.print("일수업시간? ");
    lesson.setDayHours(input.nextInt());
    input.nextLine(); 
    
    lessonList.add(lesson);
    
    System.out.println("저장하였습니다.");
  }
  
  public void listLesson() {
    // 수업 객체 목록을 복사 받을 배열을 준비하고, toArray()를 실행한다.
    // toArray()의 리턴 값은 파라미터로 넘겨준 배열의 주소이다.
    Lesson[] arr = this.lessonList.toArray(new Lesson[this.lessonList.size()]);
    for (Lesson l : arr) {
      System.out.printf("%d, %s, %s ~ %s, %d\n",
          l.getNo(), l.getTitle(), 
          l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
  }
  
  public void detailLesson(){
    System.out.print("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Lesson lesson = this.lessonList.get(index);

    if (lesson == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", lesson.getNo());
    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("수업내용: %s\n", lesson.getDescription());
    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate() );
    System.out.printf("총수업시간: %d\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %d\n", lesson.getDayHours());
  }
  
  
  public void updateLesson() {
    System.out.print("번호? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Lesson oldlesson = this.lessonList.get(index);

    if (oldlesson == null) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }


    System.out.printf("수업내용(%s)? ", oldlesson.getDescription());
    String description = input.nextLine();

    if (description.length() == 0) {
      System.out.println("수업내용 변경을 취소했습니다.");
      return;
    }
    
    Lesson newlesson = new Lesson();
    newlesson.setNo(oldlesson.getNo());
    newlesson.setTitle(oldlesson.getTitle());
    newlesson.setDescription(description);
    newlesson.setStartDate(oldlesson.getStartDate());
    newlesson.setEndDate(oldlesson.getEndDate());
    newlesson.setTotalHours(oldlesson.getTotalHours());
    newlesson.setDayHours(oldlesson.getDayHours());
    

    this.lessonList.set(index, newlesson); //지정된 위치에 새 게시글로 바꿈
    
    System.out.println("수업을 변경했습니다.");
  }
  
  public void deleteLesson() {
    System.out.print("번호? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Lesson lesson = this.lessonList.get(index);

    if (lesson == null) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }

  this.lessonList.remove(index);
  System.out.println("수업을 삭제했습니다.");
    
  }     
    
}
