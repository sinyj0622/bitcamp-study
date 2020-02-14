// 멀티 스레드 재사용 - Pooling 기법을 이용하여 생성된 객체를 재활용하기
package com.eomcs.concurrent.ex6;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam0210 {

  static class MyThread extends Thread {
    ThreadPool pool;
    int count;

    public MyThread(String name, ThreadPool pool) {
      super(name);
      this.pool = pool; // 어느 스레드풀인지 알려줘야 돌아갈수 있다
    }

    public void setCount(int count) {
      this.count = count;


      synchronized (this) {
        notify();
      }
    }

    @Override
    public void run() {

      synchronized (this) {
        try {
          while (true) {
            // 작업하라는 알림이 올 때까지 기다린다.
            wait();

            // 알림이 오면 작업을 실행한다.
            for (int i = count; i > 0; i--) {
              System.out.printf("[%s] %d\n", getName(), i);
              Thread.sleep(2000);
            }

            // 작업이 끝났으면 스레드풀로 돌아가야한다.
            pool.add(this);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  interface ThreadPool<E> {
    Thread get();

    void add(Thread obj);
  }

  static class MyThreadPool implements ThreadPool {
    ArrayList<MyThread> list = new ArrayList<>();

    public MyThreadPool() {
      MyThread t1 = new MyThread("1번 스레드=>", this);
      t1.start();
      list.add(t1);

      MyThread t2 = new MyThread("2번 스레드**>", this);
      t2.start();
      list.add(t2);

      MyThread t3 = new MyThread("3번 스레드-->", this);
      t3.start();
      list.add(t3);
    }

    // 스레드 풀에서 한 개의 스레드를 꺼낸다.
    @Override
    public MyThread get() {
      if (list.size() > 0) {
        return list.remove(0);
      }
      return null;
    }

    // 스레드를 다 쓴후에는 다시 스레드 풀에 돌려준다.
    @Override
    public void add(Thread t) { // 어떤 메소드에서 파라미터로 받아서 사용하는 관계 = 의존관계(
      list.add((MyThread) t);
    }
  }


  public static void main(String[] args) {


    MyThreadPool threadPool = new MyThreadPool();

    Scanner keyScan = new Scanner(System.in);

    while (true) {
      System.out.print("카운트? ");
      String str = keyScan.nextLine();
      if (str.equals("quit")) {
        break;
      }

      int count = Integer.parseInt(str);

      //
      MyThread t = threadPool.get();
      if (t == null) {
        System.out.println("남는 스레드가 없습니다.");
        continue;
      }
      // 스레드의 카운트를 설정한다. 그러면 카운트를 시작할 것이다.
      t.setCount(count);
    }

    System.out.println("main 스레드 종료!");
    keyScan.close();
  }
}


