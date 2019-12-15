package com.bitcamp.myproject;

import java.sql.Date;
import java.util.Scanner;
import java.util.Scanner;

public class App{
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

        int [] no = new int[100];
		String[] travelDestnation = new String[100];
		String[] travelTitle = new String[100];
		int[] person = new int[100];
		Date[] startDate = new Date[100];
		Date[] endDate = new Date[100];
		int[] travelMoney = new int[100];
		String response;


		int count = 0;
		for (int i = 0; i < 100; i++) {

			System.out.print("번호? ");
			no[i] = keyboard.nextInt();
			keyboard.nextLine();
			
			System.out.print("여행 제목? ");
			travelTitle[i] = keyboard.nextLine();

			System.out.print("어디로 떠나세요?: ");
			travelDestnation[i] = keyboard.nextLine();

			System.out.print("여행 인원? ");
			person[i] = keyboard.nextInt();

			keyboard.nextLine();

			System.out.print("여행 시작일? ");
			startDate[i] = Date.valueOf(keyboard.nextLine());

			System.out.print("여행 종료일? ");
			endDate[i] = Date.valueOf(keyboard.nextLine());

			System.out.print("예상 경비? ");
			travelMoney[i] = keyboard.nextInt();

			keyboard.nextLine();
			System.out.println();

			count++;

			System.out.print("계속 입력하시겠습니까?(Y/n) ");
			response = keyboard.nextLine();
			if (!response.equalsIgnoreCase("y")) {
				break;
			}


			System.out.print("---------------------------------");


		}
		keyboard.close();


		System.out.println();

		for (int i = 0; i < count; i++) {
			System.out.printf("%d, %s, %s, %s ~ %s\n", 
					no[i], travelTitle[i], travelDestnation[i], endDate[i], startDate[i]);

		}
		

	}
}
