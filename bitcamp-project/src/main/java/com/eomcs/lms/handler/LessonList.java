package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;

public class LessonList {
  static final int LESSON_SIZE = 100;
  
  Lesson[] lessons;
  int lessonCount = 0;
  
  public LessonList() {
    this.lessons = new Lesson[LESSON_SIZE];
  }
  
  public void add(Lesson lesson) {
    this.lessons[this.lessonCount++] = lesson;
  }

  public Lesson[] toArray() {
    Lesson[] arr = new Lesson[this.lessonCount];
    for (int i = 0; i < this.lessonCount; i++) {
    arr[i] = this.lessons[i];
    }
    return arr;
    }
  }