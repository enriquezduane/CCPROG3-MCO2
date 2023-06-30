// serves as the medium for transactions

public class Currency {
  private int one, five, ten, twenty, fifty, hundred;

  // gets the one coins
  public int getOne() {
    return one;
  }

  // gets the five coins
  public int getFive() {
    return five;
  }

  // gets the ten coins
  public int getTen() {
    return ten;
  }

  // gets the twenty bills
  public int getTwenty() {
    return twenty;
  }

  // gets the fifty bills
  public int getFifty() {
    return fifty;
  }

  // gets the hundred bills
  public int getHundred() {
    return hundred;
  }

  // decrements one coins by 1
  public void deductOne() {
    one -= 1;
  }

  // decrements five coins by 1
  public void deductFive() {
    five -= 1;
  }

  // decrements ten coins by 1
  public void deductTen() {
    ten -= 1;
  }

  // decrements twenty bills by 1
  public void deductTwenty() {
    twenty -= 1;
  }

  // decrements fifty bills by 1
  public void deductFifty() {
    fifty -= 1;
  }

  // decrements hundred bills by 1
  public void deductHundred() {
    hundred -= 1;
  }

  // gets the total amount of the currency
  public int getTotalAmount() {
    return one + (five * 5) + (ten * 10) + (twenty * 20) + (fifty * 50) + (hundred * 100);
  }

  // replenishes money based on the corresponding values of the array parameter
  public void replenishMoney(int balance[]) {
    this.one += balance[0];
    this.five += balance[1];
    this.ten += balance[2];
    this.twenty += balance[3];
    this.fifty += balance[4];
    this.hundred += balance[5];
  }

  // resets the machine balance
  public void reset() {
    this.one = 0;
    this.five = 0;
    this.ten = 0;
    this.twenty = 0;
    this.fifty = 0;
    this.hundred = 0;
  }
}
