package com.eomcs.oop.ex01.assignment;

import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {


    class Score{
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    }
    
    Scanner keyboard = new Scanner(System.in);

    Score[] s = new Score[3];
    for(int i = 0; i < s.length; i++) {
    Score score = new Score();
    System.out.print("입력: ");
    score.name = keyboard.next();
    score.kor = keyboard.nextInt();
    score.eng = keyboard.nextInt();
    score.math = keyboard.nextInt();
    
    score.sum = score.kor + score.eng + score.math;
    score.aver = score.sum / 3f;
    
    s[i] = score;
    }
    
    
    System.out.println("---------------------------");
    
    
    for (int i = 0; i < s.length; i++) {
      Score s1 = s[i];
    System.out.printf("%s %3d %3d %3d %3d %5.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.sum,
        s1.aver);
    }
  }

}
