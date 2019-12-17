// 증감 연산자 : 후위(post-fix) 증감 연산자 응용 II
package com.eomcs.basic.ex05;

public class Exam06_4 {
    public static void main(String[] args) {
        int i = 2;
        int result = i++ + i++ * i++;
        // 연산자 우선순위: 
        // 1) ++, --  ++이 *보다 우선순위이기 때문에
        // 2) *, /, %
        // 3) +, -
        // 4) =
        // 
        // int result = 2 + 3 * 4;
        // int result = 2 + 12;
        // int result = 14;
        System.out.printf("%d, %d\n", i, result);

    }
}
