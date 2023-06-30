public class Item {
  private String name;
  private int quantity;
  private int price;
  private Double calories;

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

  public void replenishQuantity(int quantityToBeAdded) {
    this.quantity += quantityToBeAdded;
  }

  public void deductQuantity() {
    this.quantity--;
  }

  public void addQuantity() {
    this.quantity++;
  }

  public void setPrice(int price) {
    this.price = price;
  }

}
