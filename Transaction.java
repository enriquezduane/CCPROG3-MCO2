
import java.util.ArrayList;

// class that deals with the transaction details
public class Transaction {
  private ArrayList<Item> items;
  private int totalAmountFromSales;
  private int startingInventory;
  private int endingInventory;

  // constructor for transaction. sets the int values to zero
  public Transaction() {
    items = new ArrayList<>();
    totalAmountFromSales = 0;
    startingInventory = 0;
    endingInventory = 0;
  }

  // gets the list of items
  public ArrayList<Item> getItems() {
    return items;
  }

  // checks if the item from the parameter is already in the list
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

  // adds the parameter to the array of items
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

  // updates the total amount from the sales
  public void updateTotalAmountFromSales(int itemPrice) {
    totalAmountFromSales += itemPrice;
  }

  // gets the total amount from the sales
  public int getTotalAmountFromSales() {
    return totalAmountFromSales;
  }

  // sets the total amount from the sales based from the parameter
  public void setTotalAmountFromSales(int totalAmountFromSales) {
    this.totalAmountFromSales = totalAmountFromSales;
  }

  // gets the starting inventory
  public int getStartingInventory() {
    return startingInventory;
  }

  // gets the ending inventory
  public int getEndingInventory() {
    return endingInventory;
  }

  // sets the ending inventory based from the parameter
  public void setEndingInventory(int endingInventory) {
    this.endingInventory = endingInventory;
  }

  // deducts ending inventory by 1
  public void deductEndingInventory() {
    this.endingInventory--;
  }

  // adds starting inventory based from the parameter
  public void addStartingInventory(int startingInventory) {
    this.startingInventory += startingInventory;
  }

  // adds ending inventory based from the parameter
  public void addEndingInventory(int endingInventory) {
    this.endingInventory += endingInventory;
  }

}