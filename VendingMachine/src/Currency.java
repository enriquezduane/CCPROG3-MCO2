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

  public void setOnes(int ones) {
    this.ones = ones;
  }

  public int getTens() {
    return tens;
  }

  public void setTens(int tens) {
    this.tens = tens;
  }

  public int getHundredths() {
    return hundredths;
  }

  public void setHundredths(int hundredths) {
    this.hundredths = hundredths;
  }

  public int getThousands() {
    return thousands;
  }

  public void setThousands(int thousands) {
    this.thousands = thousands;
  }

  @Override
  public String toString() {// overriding the toString() method
    return id + " " + name + " " + city;
  }
}
