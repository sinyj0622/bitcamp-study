// 논리 연산자 : || vs |
package com.eomcs.basic.ex05;

public class Exam03_4 {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean r = a || (b = true);
        System.out.printf("a=%b, b=%b, r=%b\n", a, b, r);
        // ||왼쪽값으로 이미 결과를 알수있기 때문에 오른쪽 문장은 실행하지 않는다
        a = true;
        b = false;
        r = a | (b = true);
        System.out.printf("a=%b, b=%b, r=%b\n", a, b, r);
    }
}


//&&, ||
//- "앞의 피연산자의 값으로 결과를 알 수 있다면 뒤의 명령은 실행하지 않는다."
//- jvm은 실행의 효율을 위해 &&연산의 오른쪽을 실행하지 않는다
//
//&, |
//- "앞의 피연산자로 결과를 알 수 있을 지라도, 
//뒤에 놓은 명령까지 모두 실행한다."
//& 연산자의 경우 왼쪽값으로 결과를 예측할수 있다 하더라고
//결과에 상관없이 & 오른쪽 문장을 무조건 실행한다