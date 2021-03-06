// 비트 이동 연산자 : >>, >>>(양수건 음수건 무조건 0을 넣는다), << 
package com.eomcs.basic.ex05;

public class Exam04_1 {
    public static void main(String[] args) {
        int i = 1;
        // 0000000 00000000 00000000 00000001 = 1
        
        System.out.println(i << 1);
     // 0 0000000 00000000 00000000 00000001x 
        // 0000000 00000000 00000000 00000010 = 2  
        
        System.out.println(i << 2);
     // 00 0000000 00000000 00000000 000001xx  
        // 0000000 00000000 00000000 00000100 = 4
        
        System.out.println(i << 3);
     //000 0000000 00000000 00000000 00001xxx 
        // 0000000 00000000 00000000 00001000 = 8       
        
        System.out.println(i << 4);
    //0000 0000000 00000000 00000000 00010xxx 
        // 0000000 00000000 00000000 00010000 = 16              
        
        // 왼쪽으로 이동 후, 
        // 오른 쪽 빈자리 : 0으로 채운다.
        // 왼쪽 경계를 넘어간 비트 : 짜른다.

        i = 0b0000_1011; // 11
        System.out.println(i << 1); // 22 => 00010110
        System.out.println(i << 2); // 44 => 00101100
        System.out.println(i << 3); // 88 => 01011000
    }
}

// 왼쪽 이동
// - 1비트 이동은 곱하기 2 한 것과 같은 효과를 준다.
// - 값을 배수로 증가 시킬때 곱하기 연산보다 왼쪽 비트이동 연산이 빠르기 때문에 실무에서는 배수 연산을
//   수행할때 비트이동 연산을 자주 사용한다