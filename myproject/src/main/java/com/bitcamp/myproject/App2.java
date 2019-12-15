package com.bitcamp.myproject;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		String[] name = new String[100];
		String[] nickname = new String[100];
		String[] email = new String[100];
		String[] passWord = new String[100];
		String[] myphoto = new String[100];
		String[] phonenumber = new String[100];
		Date[] date = new Date[100];
		String response;
		


		int count = 0;
		for (int i = 0; i < 100; i++){
			System.out.print("이름: ");
			name[i] = keyboard.nextLine();

			System.out.print("별명: ");
			nickname[i] = keyboard.nextLine();

			System.out.print("이메일: ");
			email[i] = keyboard.nextLine();

			System.out.print("암호: ");
			passWord[i] = keyboard.nextLine();

			System.out.print("사진: ");
			myphoto[i] = keyboard.nextLine();

			System.out.print("전화: ");
			phonenumber[i] = keyboard.nextLine();
			
		    date[i] = new Date(System.currentTimeMillis());
		    count++;
		    
		    System.out.println();
			
			System.out.print("계속 입력하시겠습니까?(Y/n) ");
			response = keyboard.nextLine();
			if (!response.equalsIgnoreCase("y")) {
				break;
			}
		}
		

		keyboard.close();

		System.out.println("-------------------------------"); 
		
		

		for (int i = 0; i < count; i++){
		System.out.printf("%s, %s, %s, %s\n", name[i], email[i], phonenumber[i], date[i]);
		keyboard.close();
		
		}


	}

}
