package model.core;

public class Item {
  private String name;
  private int quantity;
  private int price;
  private double calories;

  public Item(String name, int quantity, int price, double calories) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.calories = calories;
  }

  public String getName() {
    return name;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getPrice() {
    return price;
  }

  public double getCalories() {
    return calories;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
