package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);


  public static void main(String[] args) {


    LessonHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;

    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/lesson/add":
          LessonHandler.addLesson();

          break;
        case "/lesson/list":
          LessonHandler.listLesson();

          break;
        case "/member/add":
          MemberHandler.addMember();

          break;
        case "/member/list":
          MemberHandler.listMember();

          break;
        case "/board/add":
          BoardHandler.addBoard();

          break;
        case "/board/list":
          BoardHandler.listBoard();

          break;
        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }

    } while (!command.equalsIgnoreCase("quit"));

    System.out.println("안녕!");

    keyboard.close();
  }




}