public class Currency {
  private int one, five, ten, twenty, fifty, hundred;

  public int getOne() {
    return one;
  }

  public int getFive() {
    return five;
  }

  public int getTen() {
    return ten;
  }

  public int getTwenty() {
    return twenty;
  }

  public int getFifty() {
    return fifty;
  }

  public int getHundred() {
    return hundred;
  }

  public void addOne() {
    one += 1;
  }

  public void addFive() {
    five += 1;
  }

  public void addTen() {
    ten += 1;
  }

  public void addTwenty() {
    twenty += 1;
  }

  public void addFifty() {
    fifty += 1;
  }

  public void addHundred() {
    hundred += 1;
  }

  public void deductOne() {
    one -= 1;
  }

  public void deductFive() {
    five -= 1;
  }

  public void deductTen() {
    ten -= 1;
  }

  public void deductTwenty() {
    twenty -= 1;
  }

  public void deductFifty() {
    fifty -= 1;
  }

  public void deductHundred() {
    hundred -= 1;
  }

  public int getTotalAmount() {
    return one + (five * 5) + (ten * 10) + (twenty * 20) + (fifty * 50) + (hundred * 100);
  }

  public void replenishMoney(int balance[]) {
    this.one += balance[0];
    this.five += balance[1] / 5;
    this.ten += balance[2] / 10;
    this.twenty += balance[3] / 20;
    this.fifty += balance[4] / 50;
    this.hundred += balance[5] / 100;
  }
}
