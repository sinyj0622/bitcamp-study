// 스레드 재사용 - 3단계) sleep()/timeout 을 활용한 스레드 재사용
package com.eomcs.concurrent.ex6;

import java.util.Scanner;

public class Exam0130 {

  public static void main(String[] args) {
    class MyThread extends Thread {
      boolean enable;
      int count;

      public void setCount(int count) {
        this.count = count;

        // 카운트를 설정하면 스레드의 작업을 허락하게 하자
        this.enable = true;
      }

      @Override
      public void run() {
        System.out.println("스레드 시작!");
        try {
          while (true) {
            System.out.println("스레드를 10초동안 잠들게한다");
            Thread.sleep(10000);

            // 무조건 작업하지 말고,
            // enable이 true 일때만 작업하게 하자!
            if (!enable) {
              continue;
            }

            System.out.println("카운트 시작");
            for (int i = count; i > 0; i--) {
              System.out.println("==>" + i);
              Thread.sleep(1000);
            }
            // 스레드에게 맡겨진 작업이 끝나면 비활성 상태로 설정한 후
            // 10초동안 잠든다.
            enable = false;
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    MyThread t = new MyThread();

    t.start();

    Scanner keyScan = new Scanner(System.in);

    while (true) {
      System.out.print("카운트? ");
      String str = keyScan.nextLine();
      if (str.equals("quit")) {
        break;
      }

      int count = Integer.parseInt(str);
      t.setCount(count);

      // 이전 버젼 보다는 나아졌다.
      // 스레드가 작업을 완료하면 10초동안 작든다.
      // 10초 후에 깨어났을때 카운트 값이 설정되어 있지 않으면 다시 잠든다.
      // 카운트 값이 설정되면서 enable이 활성화 상태라면 작업을 실행한다.
      // 작업이 끝나면 enable이 비활성으로 만든 후 잠든다.
    }

    System.out.println("main 스레드 종료!");
    keyScan.close();
  }
}


