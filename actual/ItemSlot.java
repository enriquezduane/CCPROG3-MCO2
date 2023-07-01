import java.util.ArrayList;

// responsible for storing items
public class ItemSlot {
  ArrayList<Item> items;

  // constructor for itemslot
  public ItemSlot() {
    items = new ArrayList<>();
  }

  // gets items in the slot
  public ArrayList<Item> getItems() {
    return items;
  }

  // displays items in a formatted manner
  public void displayItems() {
    System.out.println("Name       Quantity  Price    Calories");
    for (Item item : items) {
      String name = item.getName();
      int quantity = item.getQuantity();
      int price = item.getPrice();
      double calories = item.getCalories();

      System.out.printf("%-10s %-9d %-8d %-8.2f%n", name, quantity, price, calories);
    }
  }

  // gets the number of items
  public int getNumberOfItems() {
    return items.size();
  }

  // creates the item and passes it to the item constructor
  public void addItem(String name, int quantity, int price, double calories) {
    items.add(new Item(name, quantity, price, calories));
  }

}
