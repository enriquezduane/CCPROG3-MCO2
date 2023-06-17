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

  public void replenishOnes(int onesToBeAdded) {
    this.ones += onesToBeAdded;
  }

  public void replenishTens(int tensToBeAdded) {
    this.tens += tensToBeAdded;
  }

  public void replenishHundredths(int hundredthsToBeAdded) {
    this.hundredths += hundredthsToBeAdded;
  }

  public void replenishThousands(int thousandsToBeAdded) {
    this.thousands += thousandsToBeAdded;
  }
}
