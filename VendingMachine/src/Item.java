public class Item {
  private String name;
  private int quantity;
  private Double price;
  private Double calories;

  public Item(String name, int quantity, Double price, Double calories) {
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

  public Double getPrice() {
    return price;
  }

  public Double getCalories() {
    return calories;
  }

  public void addQuantity(int quantityToBeAdded) {
    this.quantity += quantityToBeAdded;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Item Name: " + name + "\nQuantity: " + quantity + "\nPrice: " + price + "\nCalories: " + calories;
  }

}
