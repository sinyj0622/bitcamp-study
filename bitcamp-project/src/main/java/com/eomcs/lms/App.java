package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
	static Scanner keyboard = new Scanner(System.in);
	
	static class Lesson{
		int no;
		String title;
		String description;
		Date startDate;
		Date endDate;
		int totalHours;
		int dayHours;
	}
	
	static final int LESSONSIZE = 100;   
	static Lesson[] lessons = new Lesson[LESSONSIZE];
	static int lessonCount = 0;
	
	static class Member {
		int no;
		String name;
		String email;
		String password;
		String photo;
		String tel;
		Date registeredDate;
	}
	
	static final int MEMBERSIZE = 100;
	static Member[] members = new Member[MEMBERSIZE];
	static int memberCount = 0;
	
	
	static class Board { 
		int no;
		String title;
		Date date;
		int viewCount;
	}
	
	static final int BOARDSIZE = 100;
	static Board[] boards = new Board[BOARDSIZE];
	static int boardCount = 0;    
	
	static String command;

	public static void main(String[] args) {

		do {
			prompt();
			switch (command) {
			case "/lesson/add":
				addLesson();
				break;
			case "/lesson/list":
				listLesson();
				break;		

			case "/member/add":
				addMember();
				break;
			case "/member/list":
				listMember();
				break;
			case "/board/add" :
				addBoard();
				break;
			case "/board/list":
				listBoard();
				break;
			default :
				if(!command.equalsIgnoreCase("quit")) {
					System.out.println("실행할 수 없는 명령입니다.");
				}

			}
		} while(!command.equalsIgnoreCase("quit"));
		System.out.println("안녕!");


	}
	
	
	
	static void addLesson() {
		Lesson lesson = new Lesson();

		System.out.print("번호? ");
		lesson.no = keyboard.nextInt();

		keyboard.nextLine(); 

		System.out.print("수업명? ");
		lesson.title = keyboard.nextLine();

		System.out.print("설명? ");
		lesson.description = keyboard.nextLine();

		System.out.print("시작일? ");
		lesson.startDate = Date.valueOf(keyboard.next());

		System.out.print("종료일? ");
		lesson.endDate = Date.valueOf(keyboard.next());

		System.out.print("총수업시간? ");
		lesson.totalHours = keyboard.nextInt();

		System.out.print("일수업시간? ");
		lesson.dayHours = keyboard.nextInt();
		keyboard.nextLine(); 

		lessons[lessonCount++] = lesson;

	}
	static void listLesson() {
		for (int i = 0; i < lessonCount; i++) {
			Lesson l = lessons[i];
			System.out.printf("%d, %s, %s ~ %s, %d\n",
					l.no, l.title, l.startDate, l.endDate, l.totalHours);
		}
	}
	
	
	static void addMember() {
		Member member = new Member();

		System.out.print("번호?: ");
		member.no = keyboard.nextInt();
		keyboard.nextLine();

		System.out.print("이름?: ");
		member.name = keyboard.nextLine();

		System.out.print("이메일?: ");
		member.email = keyboard.nextLine();

		System.out.print("암호?: ");
		member.password = keyboard.nextLine();

		System.out.print("사진?: ");
		member.photo = keyboard.nextLine();

		System.out.print("전화?: ");
		member.tel = keyboard.nextLine();

		member.registeredDate = new Date(System.currentTimeMillis());

		members[memberCount++] = member;

	}
	
	 static void listMember() {
		 for (int i = 0; i < memberCount; i++) {  
				Member m = members[i];
				System.out.printf("%d, %s, %s,  %s, %s\n", 
						m.no, m.name, m.email, m.tel, m.registeredDate);
			}
	 }
	 
	 static void addBoard() {
		 Board board = new Board(); 

			System.out.print("번호? ");
			board.no = keyboard.nextInt();
			keyboard.nextLine();

			System.out.print("내용? ");
			board.title = keyboard.nextLine();

			board.date = new Date(System.currentTimeMillis());
			board.viewCount = 0;


			boards[boardCount++] = board;
	 }
	
	 static void listBoard() {
		 for (int i = 0; i < boardCount; i++) {
				Board b = boards[i];
				System.out.printf("%d, %s, %s, %d\n", 
						b.no, b.title, b.date, b.viewCount);
			}
	 }
	
	 
	 static void prompt() {
		 System.out.print("명령> ");
			command = keyboard.nextLine();
		 
	 }
}









