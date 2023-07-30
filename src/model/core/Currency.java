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

  public void setOne(int value) {
    this.one = value;
  }

  public void setFive(int value) {
    this.five = value;
  }

  public void setTen(int value) {
    this.ten = value;
  }

  public void replenishMoney(int balance[]) {
    this.one += balance[0];
    this.five += balance[1];
    this.ten += balance[2];
  }

  public void reset() {
    this.one = 0;
    this.five = 0;
    this.ten = 0;
  }
}
