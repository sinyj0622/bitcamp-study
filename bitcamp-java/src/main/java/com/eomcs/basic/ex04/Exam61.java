package com.eomcs.basic.ex04;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Exam61 {
  public static void main(String[] args){
   
    // 배열사용전
   int kor, eng, math, soc, mus;

   // 배열 사용후 
   int[] score = new int[5];



   int score2[] = new int[5];

   // 배열에 값을 넣는 방법  (방번호)
   score[0] = 100;
   score[1] = 90;
   score[2] = 80;
   score[3] = 70;
   score[4] = 60;

   //score[-1] = 100; //런타임 에러
   //score[5] = 100; //런타임 에러

   // 배열 레퍼런스와 인스턴스를 따로 선언
   int[] arr1 = null; // 주소가 0 > 의미? 메모리를 가리키지 않음

   //arr1[0] = 100; //런타임 에러

   // 배열 인스턴스 생성
   arr1 = new int[5];
   arr1[0] = 100; //ok
   arr1[1] = 100; //ok

   // 배열 사용
   System.out.println(arr1[0]);
   System.out.println(arr1[1]);

   int[] arr2;

   // 배열 레퍼런스는 배열 인스턴스의 주소를 담는다.
   arr2 = arr1; //arr1에 저장된 배열 인스턴스 주소를 담는다.

   
   System.out.println(arr1[0]);
   arr2[0] = 300;
   System.out.println(arr1[0]);

   // 배열 인스턴스의 각 항목은 생성되는 순산 기본값으로 자동 초기화 된다
     // 일반 변수와 달리 new 명령으로 확보된 메모리는 종류에 상관없이 기본 값으로 자동 초기화 된다.
    // 따라서 배열 메모리 또한 생성되는 순간 기본 값으로 자동 초기화 된다.
    // - 정수 배열(byte[], short[], int[], long[]) : 0
    // - 부동소수점 배열(float[], double[]) : 0.0
    // - 논리 배열(boolean[]) : false 
    // - 문자 배열(char[]) : '\u0000'
    // - 주소 변수(Object[]) : null

   System.out.println(arr1[2]); //초기화 시키지 않았다

   int[] arr3 = new int[3];
   arr3[0] = 30;

   arr2 = arr3;
   System.out.println(arr2[0]);

   arr1 = arr2;
   System.out.println(arr1[0]);

   // 그럼 arr1에 저장되었던 기존 배열 인스턴스에는 어떻게 접근하는가? 
   // =>처음 생성했던 배열 인스턴스의 주소를 갖고있는 레퍼런스가 없기때문에 접근할수없다
   // 이렇게 주소를 잃어버려 접근할수 없는 메모리를 garbage 라고한다
   // 가비지는 jvm 실행중에 메모리가 부족할떄 가비지 수집기(garbage collector)에 의해
   // 메모리에서 해제된다


   // 전산학에서는 가비지를 "dangling object" 라고 한다



    // 배열 인스턴스 생성과 동시에 값 초기화시키기

    int[] arr4 =new int[3];
    arr4[0] = 100; // 인스턴스(값) 초기화
    arr4[1] = 90;
    arr4[2] = 80;
   

    // **초기화시키는 값 개수 만큼 배열 항목이 생성된다**
    int[] arr5 = new int[] {100,90,80};



    // 인스턴스 생성과 동시에 값을 지정 할때는 배열 개수를 지정 안된다
    // int[] arr6 = new int[3] {100,90,80}; //런타임 에러


    // 배열 선언과 동시에 인스턴스를 초기화 시킬때는
    // new int[]를 생략할수있다
    int[] arr7 = {100,90,80};



    // 레터펀스를
    int[] arr8;
    //arr8 = {100,90,80}; //컴파일오류
    arr8 = new int[]{100,90,80}; //ok




  



  }
}