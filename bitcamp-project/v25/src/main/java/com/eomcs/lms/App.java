package com.eomcs.lms;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.Prompt;


public class App {

  static Scanner keyboard = new Scanner(System.in);
  
  // java.util.Stack에서 제공하는 iterator 객체는 FIFO 방식으로 값을 꺼내준다.
  // LIFO 방식으로 꺼내는 Iterator가 필요하다면,
  // java.util.Deque 구현체를 사용하라~~!!!!!
  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);

    // 단지 유지보수를 좋게 하기 위해 ArrayList와 LinkedList의 공통 분모를 뽑아서
    // 만든 클래스가 List이다.
    // List의 클래스는 실제 작업을 하는 클래스가 아니다
    // 그럼에도 불구하고 개발자가 다음과 같이 List객체를 사용하려 한다면 막을 수 없다.
    // => 실행할 때 오류가 발생할 것이다
    // => BoardHandler의 경우 아무런 작업을 수행하지 않을 것이다.
    // 왜? List 클래스에 정으된 메서드는 아무것도 하지 않는다.
    //
    //List<Board> boardList = new List<>();
    //
    // 해결책?
    // => generalization 을 통해 만든 클래스의 경우 서브 클래스에게 공통 분모를 물려주기 위한 
    //    용도로 사용된다.
    // => 이런 류의 클래스는 직접 인스턴스를 생성하지 못하도록 해서 직접 사용하는 것을 막아야한다.
    // => 이런 용도로 사용하는 문법이 "추상클래스(Abstract Class)"이다
    // List 클래스(AbstractList로 이름 변경함)를 추상 클래스로 만들면,
    // 다음과 같이 인스턴스를 생성 할 수 없다.
    // 아예 인스턴스 생성을 원천적으로 차단하는 효과가 있다.
    //
    //  AbstractList<Board> boardList = new AbstractList<>(); //컴파일오류! 인스턴스 생성 놉!
    //
    //
    
    LinkedList<Board> boardList = new LinkedList<>();
    BoardHandler boardHandler = new BoardHandler(prompt, boardList);
    
    ArrayList<Lesson> lessonList = new ArrayList<>();
    LessonHandler lessonHandler = new LessonHandler(prompt, lessonList);
    
    LinkedList<Member> memberList = new LinkedList<>();
    MemberHandler memberHandler = new MemberHandler(prompt, memberList);

    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();


      if (command.length() == 0)
        continue;

      commandStack.push(command);
      commandQueue.offer(command);

      switch (command) {
        case "/lesson/add":
          lessonHandler.addLesson();
          break;
        case "/lesson/list":
          lessonHandler.listLesson();
          break;        
        case "/lesson/detail":
          lessonHandler.detailLesson();
          break;
        case "/lesson/update":
          lessonHandler.updateLesson();
          break;
        case "/lesson/delete":
          lessonHandler.deleteLesson();
          break;
        case "/member/add":
          memberHandler.addMember();
          break;
        case "/member/list":
          memberHandler.listMember();
          break;
        case "/member/detail":
          memberHandler.detailMember();
          break;
        case "/member/update":
          memberHandler.updateMember();
          break;
        case "/member/delete":
          memberHandler.deleteMember();
          break;
        case "/board/add":
          boardHandler.addBoard();
          break;
        case "/board/list":
          boardHandler.listBoard();
          break;
        case "/board/detail":
          boardHandler.detailBoard();
          break;
        case "/board/update":
          boardHandler.updateBoard();
          break;
        case "/board/delete":
          boardHandler.deleteBoard();
          break;
        case "history":
          printCommadHistory(commandStack.iterator());
          break; 
        case "history2":
          printCommadHistory(commandQueue.iterator());
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
  
  
  // 이전에는 Stack에서 값을 꺼내는 방법과 Queue에서 값을 꺼내는 방법이 다르기 때문에
  // printCommandSHistory()와 2 메서드를 따로 정의했다
  // 이제 스택과 큐는 일관된 방식으로 값을 꺼내주는 Iterator가 있기 때문에
  // 두 메서드를 하나로 합칠 수 있다.
  // 파라미터로 Iterator를 받아서 처리하기만 하면 된다.
  private static void printCommadHistory(Iterator<String> iterator) {
    int count = 0;
    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;

      if ((count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }


  

}





