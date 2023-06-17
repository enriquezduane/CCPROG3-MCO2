import java.util.ArrayList;

public class ItemSlot {
  ArrayList<Item> item;
  private int quantity;
  private double price;

  public ItemSlot() {
    item = new ArrayList<>();
    quantity = 0;
    price = 0.0;
  }

  public ArrayList<Item> getItems() {
    return item;
  }

  public void setItems(ArrayList<Item> item) {
    this.item = item;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean isAvailable() {
    return quantity > 0;
  }

  public void dispenseItem() {
    if (quantity > 0) {
      quantity--;
    }
  }

  public void restock(int quantity) {
    this.quantity += quantity;
  }
}
