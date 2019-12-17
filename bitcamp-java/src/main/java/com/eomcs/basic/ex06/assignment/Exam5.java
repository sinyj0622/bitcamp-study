package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

//밑변 길이? 5
//*
//**
//***
//****
//*****
    
public class Exam5 {
  public static void main(String[] args) {
    Scanner keyscan = new Scanner(System.in);

    System.out.print("밑변 길이? ");
    int len = keyscan.nextInt();

    int i = 1;
    while (i <= len) { //밑변의 길이와 같은
      int j = 1;
      while (j <= i) {
        System.out.print("*");
       j++;
      }
      System.out.println();
      i++;
    }


      keyscan.close();
    }
  }

