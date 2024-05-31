package org.learn.curs02.fraction;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class Fration implements Fractionable{
  private int num;
  private int denum;
  @Override
  public double doubleValue() {
    System.out.println("invoke double value");
    return (double) num/denum;
  }

  @Override
  public void setNum(int num) {
    this.num = num;
  }

  @Override
  public void setDenum(int denum) {
    this.denum = denum;
  }
}
