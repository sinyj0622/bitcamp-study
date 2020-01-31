package com.eomcs.lms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

public class DataLoaderListener implements ApplicationContextListener {


  List<Board> boardList = new LinkedList<>();
  List<Member> memberList = new LinkedList<>();
  List<Lesson> lessonList = new ArrayList<>();


  @Override
  public void contextInitionalize(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");

    loadBoardData();
    loadMemberData();
    loadLessonData();

    context.put("boardList", boardList);
    context.put("memberList", memberList);
    context.put("LessonList", lessonList);
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    System.out.println("데이터를 저장합니다.");

    saveBoardData();
    saveMemberData();
    saveLessonData();

  }


  @SuppressWarnings("unchecked")
  private void loadBoardData() {
    File file = new File("./board.ser2");

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {

      boardList = (List<Board>) in.readObject();


      System.out.printf("총 % d개의 게시물 데이터를 로딩 하였습니다\n", boardList.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }


  private void saveBoardData() {
    File file = new File("./board.ser2");

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {

      out.writeObject(boardList);
      System.out.printf("총 %d 개의 게시물 데이터를 저장했습니다.\n", boardList.size());


    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }


  @SuppressWarnings("unchecked")
  private void loadMemberData() {
    File file = new File("./member.ser2");

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {

      memberList = (List<Member>) in.readObject();

      System.out.printf("총 % d개의 회원 데이터를 로딩 하였습니다\n", memberList.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private void saveMemberData() {
    File file = new File("./member.ser2");

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {

      out.writeObject(memberList);

      System.out.printf("총 %d 개의 회원 데이터를 저장했습니다.\n", memberList.size());


    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }



  @SuppressWarnings("unchecked")
  private void loadLessonData() {
    File file = new File("./lesson.ser2");

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {

      lessonList = (List<Lesson>) in.readObject(); // 클래스정보 + 인스턴스변수 + 인스턴스값

      System.out.printf("총 % d개의 수업 데이터를 로딩 하였습니다\n", lessonList.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private void saveLessonData() {
    File file = new File("./lesson.ser2");

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {

      out.writeObject(lessonList);


      System.out.printf("총 %d 개의 수업 데이터를 저장했습니다.\n", lessonList.size());


    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

}
