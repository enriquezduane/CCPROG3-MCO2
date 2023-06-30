// the item object that contains the item details

public class Item {
  private String name;
  private int quantity;
  private int price;
  private Double calories;

  // constructor for item that assigns
  public Item(String name, int quantity, int price, double calories) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.calories = calories;
  }

  // gets the name of the item
  public String getName() {
    return name;
  }

  // gets the quantity of the item
  public int getQuantity() {
    return quantity;
  }

  // gets the price of the item
  public int getPrice() {
    return price;
  }

  // gets the calories of the item
  public double getCalories() {
    return calories;
  }

  // replenishes the quanity of the item with respect to the parameter
  public void replenishQuantity(int quantityToBeAdded) {
    this.quantity += quantityToBeAdded;
  }

  // deducts the quantity of the product by 1
  public void deductQuantity() {
    this.quantity--;
  }

  // increments the quantity of the product by 1
  public void addQuantity() {
    this.quantity++;
  }

  // sets the price of an item with respect to the parameter
  public void setPrice(int price) {
    this.price = price;
  }

}
