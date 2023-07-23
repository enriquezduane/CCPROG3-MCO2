package model.core;

public class Currency {
  private int one, five, ten;

  public Currency() {
    this.one = 0;
    this.five = 0;
    this.ten = 0;
  }

  public int getTotalAmount() {
    return (one * 1) + (five * 5) + (ten * 10);
  }

  public int getOne() {
    return one;
  }

  public int getFive() {
    return five;
  }

  public int getTen() {
    return ten;
  }
}
