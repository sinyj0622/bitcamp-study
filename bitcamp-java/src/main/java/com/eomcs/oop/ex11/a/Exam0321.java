// non-static nested class = inner class
package com.eomcs.oop.ex11.a;

public class Exam0321 {

  void m0() {
    //

  }

  void m1() {


    class A {
    }
    class B {
    }

    new A();
    new B();
  }

  void m2() {
    class A {
    }
    class X {
    }

    new A();
    new X();
  }

}
