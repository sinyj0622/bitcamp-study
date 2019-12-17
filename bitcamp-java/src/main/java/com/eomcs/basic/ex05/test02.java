
package com.eomcs.basic.ex05;

import java.util.Scanner;

public class test02 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		// 입력? 7 4 12 8 9
		// 최소값?
		// 최대값?

		System.out.print("입력? ");  
		int[] arr = new int[5];

		for (int i = 0; i < 5; i++) {
			arr[i] = keyboard.nextInt();
		}



		int max = arr[0];
		for (int i = 1; i < 5; i++){
			if (max < arr[i]) {
				max = arr[i];	
			} 
		}

		System.out.printf("최대값: %d\n", max);

		int min= arr[0];
		for (int i = 1; i < 5; i++){
			if (min > arr[i]) {
				min = arr[i];
			} 
		}

		System.out.printf("최소값: %d\n", min);


	}
}