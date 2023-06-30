import java.util.ArrayList;

public class ItemSlot {
  ArrayList<Item> items;

  public ItemSlot() {
    items = new ArrayList<>();
  }

  public ArrayList<Item> getItems() {
    return items;
  }

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

  public int getNumberOfItems() {
    return items.size();
  }

  public void addItem(String name, int quantity, int price, double calories) {
    items.add(new Item(name, quantity, price, calories));
  }

}
