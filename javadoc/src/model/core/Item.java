package model.core;

/**
 * The Item class represents an item available in the vending machine. It contains information about the item's name,
 * quantity, price, and calorie content.
 */
public class Item {
  private String name;
  private int quantity;
  private int price;
  private double calories;

  /**
   * Constructs a new Item object with the specified attributes.
   *
   * @param name The name of the item.
   * @param quantity The quantity of the item available in the vending machine.
   * @param price The price of the item.
   * @param calories The calorie content of the item.
   */
  public Item(String name, int quantity, int price, double calories) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.calories = calories;
  }

  /**
   * Retrieves the name of the item.
   *
   * @return The name of the item.
   */
  public String getName() {
    return name;
  }

  /**
   * Retrieves the quantity of the item available in the vending machine.
   *
   * @return The quantity of the item.
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Retrieves the price of the item.
   *
   * @return The price of the item.
   */
  public int getPrice() {
    return price;
  }

  /**
   * Retrieves the calorie content of the item.
   *
   * @return The calorie content of the item.
   */
  public double getCalories() {
    return calories;
  }

  /**
   * Sets the quantity of the item available in the vending machine.
   *
   * @param quantity The new quantity of the item.
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Sets the price of the item.
   *
   * @param price The new price of the item.
   */
  public void setPrice(int price) {
    this.price = price;
  }
}
