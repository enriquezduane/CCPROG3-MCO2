public class Currency {
  private int ones, tens, hundredths, thousands;

  public Currency() {
    this.ones = 0;
    this.tens = 0;
    this.hundredths = 0;
    this.thousands = 0;
  }

  public int getTotalAmount() {
    return ones + (tens * 10) + (hundredths * 100) + (thousands * 1000);
  }

  public int getOnes() {
    return ones;
  }

  public int getTens() {
    return tens;
  }

  public int getHundredths() {
    return hundredths;
  }

  public int getThousands() {
    return thousands;
  }

  public void replenishMoney(int ones, int tens, int hundredths, int thousands) {
    this.ones += ones;
    this.tens += tens;
    this.hundredths += hundredths;
    this.thousands += thousands;
  }
}
