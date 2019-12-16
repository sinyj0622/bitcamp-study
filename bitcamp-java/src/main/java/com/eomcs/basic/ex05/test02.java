
package com.eomcs.basic.ex05;

import java.util.Scanner;

public class test02 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		// 입력? 7 4 12 8 9
		// 최소값?
		// 최대값?
		int[] arr = new int[] {7, 4, 12, 8, 9};
		int max = arr[0];
		int min = arr[0];
		
		System.out.print("입력? ");
		keyboard.nextInt();

		for (int i = 1; i < arr.length; i++) { 
			if ( arr[i] > max ) { max = arr[i]; 
			} else if ( arr[i] < min ) { min = arr[i]; 
			}

		}


		System.out.println("최대값: " + max);     
		System.out.println("최소값: " + min);     



	}
}