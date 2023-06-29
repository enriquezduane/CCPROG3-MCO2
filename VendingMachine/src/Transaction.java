
import java.util.ArrayList;

public class Transaction {
  private ArrayList<Item> items;
  private int totalAmountFromSales;
  private int startingInventory;
  private int endingInventory;

  public Transaction() {
    items = new ArrayList<>();
    totalAmountFromSales = 0;
    startingInventory = 0;
    endingInventory = 0;
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  public boolean isItemInList(Item item) {
    int i;

    if (items.size() == 0) {
      return false;
    }

    for (i = 0; i < items.size(); i++) {
      if (items.get(i).getName().equals(item.getName()))
        return true;
    }
    return false;
  }

  public void addItem(Item item) {
    int i;
    if (isItemInList(item)) {
      for (i = 0; i < items.size(); i++) {
        if (items.get(i).getName().equals(item.getName())) {
          items.get(i).addQuantity();
        }
      }
    } else {
      items.add(new Item(item.getName(), 1, item.getPrice(), item.getQuantity()));
    }
  }

  public void updateTotalAmountFromSales(int itemSale) {
    totalAmountFromSales += itemSale;
  }

  public int getTotalAmountFromSales() {
    return totalAmountFromSales;
  }

  public void setTotalAmountFromSales(int totalAmountFromSales) {
    this.totalAmountFromSales = totalAmountFromSales;
  }

  public int getStartingInventory() {
    return startingInventory;
  }

  public int getEndingInventory() {
    return endingInventory;
  }

  public void setEndingInventory(int endingInventory) {
    this.endingInventory = endingInventory;
  }

  public void deductEndingInventory() {
    this.endingInventory--;
  }

  public void addStartingInventory(int startingInventory) {
    this.startingInventory += startingInventory;
  }

}