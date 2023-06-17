import java.util.ArrayList;

public class ItemSlot {
  private static int numItems;
  ArrayList<Item> items;

  public ItemSlot() {
    items = new ArrayList<>();
  }

  public void addItem(String name, int quantity, Double price, Double calories) {
    items.add(new Item(name, quantity, price, calories));
    numItems += 1;
  }

  // returns true if items inside the slot reached the max number of items (8)
  public boolean isMaxItemsReached() {
    return numItems == 8;
  }

}
