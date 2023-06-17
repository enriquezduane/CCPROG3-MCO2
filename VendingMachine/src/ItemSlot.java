import java.util.ArrayList;

public class ItemSlot {
  ArrayList<Item> items;

  public ItemSlot() {
    items = new ArrayList<>();
  }

  public void addItem(String name, int quantity, Double price, Double calories) {
    items.add(new Item(name, quantity, price, calories));
  }

  // returns true if items inside the slot reached the max number of items (8)
  public boolean isMaxItemsReached() {
    return this.items.size() == 8;
  }

}
