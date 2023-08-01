package model.core;

/**
 * The Currency class represents the currency used in the vending machine application. It keeps track of the number
 * of one, five, and ten currency units. Users can interact with this class to set and get the number of currency
 * units, calculate the total amount of currency, replenish money, and reset the currency counts.
 */
public class Currency {
  private int one, five, ten;

  /**
   * Constructs a new Currency object with all currency counts initialized to zero.
   */
  public Currency() {
    this.one = 0;
    this.five = 0;
    this.ten = 0;
  }

  /**
   * Calculates and returns the total amount of currency represented by the current counts of one, five, and ten
   * currency units.
   *
   * @return The total amount of currency.
   */
  public int getTotalAmount() {
    return (one * 1) + (five * 5) + (ten * 10);
  }

  /**
   * Retrieves the number of one currency units.
   *
   * @return The count of one currency units.
   */
  public int getOne() {
    return one;
  }

  /**
   * Retrieves the number of five currency units.
   *
   * @return The count of five currency units.
   */
  public int getFive() {
    return five;
  }

  /**
   * Retrieves the number of ten currency units.
   *
   * @return The count of ten currency units.
   */
  public int getTen() {
    return ten;
  }

  /**
   * Sets the number of one currency units to the specified value.
   *
   * @param value The new count of one currency units.
   */
  public void setOne(int value) {
    this.one = value;
  }

  /**
   * Sets the number of five currency units to the specified value.
   *
   * @param value The new count of five currency units.
   */
  public void setFive(int value) {
    this.five = value;
  }

  /**
   * Sets the number of ten currency units to the specified value.
   *
   * @param value The new count of ten currency units.
   */
  public void setTen(int value) {
    this.ten = value;
  }

  /**
   * Replenishes the currency counts with the provided array of currency values.
   *
   * @param balance An array containing the counts of one, five, and ten currency units to replenish.
   */
  public void replenishMoney(int balance[]) {
    this.one += balance[0];
    this.five += balance[1];
    this.ten += balance[2];
  }

  /**
   * Resets all currency counts to zero.
   */
  public void reset() {
    this.one = 0;
    this.five = 0;
    this.ten = 0;
  }
}
