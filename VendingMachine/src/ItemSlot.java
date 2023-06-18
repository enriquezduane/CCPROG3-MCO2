import java.util.ArrayList;

public class ItemSlot {
  ArrayList<Item> items;

  public ItemSlot() {
    items = new ArrayList<>();
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  public void addItem(String name, int quantity, Double price, Double calories) {
    items.add(new Item(name, quantity, price, calories));
  }

}
