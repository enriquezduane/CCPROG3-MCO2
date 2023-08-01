package model.core;

import java.util.ArrayList;

/**
 * The Transaction class represents a vending machine transaction. It keeps track of the items purchased during the
 * transaction, the total amount earned from sales, and the starting and ending inventory counts.
 */
public class Transaction {
  private ArrayList<Item> items;
  private int totalAmountFromSales;
  private int startingInventory;
  private int endingInventory;

  /**
   * Constructs a new Transaction object with all values initialized to zero.
   */
  public Transaction() {
    items = new ArrayList<>();
    totalAmountFromSales = 0;
    startingInventory = 0;
    endingInventory = 0;
  }

  /**
   * Retrieves the list of items purchased during the transaction.
   *
   * @return An ArrayList containing the items purchased during the transaction.
   */
  public ArrayList<Item> getItems() {
    return items;
  }

  /**
   * Checks if the specified item is already in the list of purchased items.
   *
   * @param item The item to check.
   * @return true if the item is already in the list, false otherwise.
   */
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

  /**
   * Adds the specified item to the list of purchased items. If the item is already in the list, its quantity is updated.
   *
   * @param item The item to add to the list of purchased items.
   */
  public void addItem(Item item) {
    int i;
    if (isItemInList(item)) {
      for (i = 0; i < items.size(); i++) {
        if (items.get(i).getName().equals(item.getName())) {
          items.get(i).setQuantity(items.get(i).getQuantity() + 1);
        }
      }
    } else {
      items.add(new Item(item.getName(), 1, item.getPrice(), item.getCalories()));
    }
  }

  /**
   * Updates the total amount earned from sales by adding the specified item price to the total.
   *
   * @param itemPrice The price of the item sold in the transaction.
   */
  public void updateTotalAmountFromSales(int itemPrice) {
    totalAmountFromSales += itemPrice;
  }

  /**
   * Retrieves the total amount earned from sales in the transaction.
   *
   * @return The total amount earned from sales.
   */
  public int getTotalAmountFromSales() {
    return totalAmountFromSales;
  }

  /**
   * Sets the total amount earned from sales to the specified value.
   *
   * @param totalAmountFromSales The new total amount earned from sales.
   */
  public void setTotalAmountFromSales(int totalAmountFromSales) {
    this.totalAmountFromSales = totalAmountFromSales;
  }

  /**
   * Retrieves the starting inventory count at the beginning of the transaction.
   *
   * @return The starting inventory count.
   */
  public int getStartingInventory() {
    return startingInventory;
  }

  /**
   * Retrieves the ending inventory count at the end of the transaction.
   *
   * @return The ending inventory count.
   */
  public int getEndingInventory() {
    return endingInventory;
  }

  /**
   * Sets the ending inventory count to the specified value.
   *
   * @param endingInventory The new ending inventory count.
   */
  public void setEndingInventory(int endingInventory) {
    this.endingInventory = endingInventory;
  }

  /**
   * Sets the starting inventory count to the specified value.
   *
   * @param startingInventory The new starting inventory count.
   */
  public void setStartingInventory(int startingInventory) {
    this.startingInventory = startingInventory;
  }

  /**
   * Deducts one from the ending inventory count.
   */
  public void deductEndingInventory() {
    this.endingInventory--;
  }

  /**
   * Adds the specified quantity to the starting inventory count.
   *
   * @param startingInventory The quantity to add to the starting inventory count.
   */
  public void addStartingInventory(int startingInventory) {
    this.startingInventory += startingInventory;
  }

  /**
   * Adds the specified quantity to the ending inventory count.
   *
   * @param endingInventory The quantity to add to the ending inventory count.
   */
  public void addEndingInventory(int endingInventory) {
    this.endingInventory += endingInventory;
  }
}
