package com.eomcs.oop.ex05.Test;

public class Sedan extends Car {

  public boolean sunroof;
  public boolean auto;

  public Sedan(String model, String maker, int capacity, 
      boolean sunroof, boolean auto) {

    super(model, maker, capacity);

    this.sunroof = sunroof;
    this.auto = auto;
  }
}
