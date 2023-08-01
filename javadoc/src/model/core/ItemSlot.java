package model.core;

import java.util.ArrayList;

/**
 * The ItemSlot class represents a slot in the vending machine that contains a collection of items. Each item slot
 * holds a list of Item objects with their respective attributes such as name, quantity, price, and calorie content.
 */
public class ItemSlot {
  private ArrayList<Item> items;

  /**
   * Constructs a new ItemSlot object with the specified attributes for the items in the slot.
   *
   * @param name     An array of item names.
   * @param quantity An array of item quantities available in the slot.
   * @param price    An array of item prices.
   * @param calories An array of item calorie contents.
   */
  public ItemSlot(String[] name, int[] quantity, int[] price, double[] calories) {
    items = new ArrayList<>();
    int i;
    for (i = 0; i < name.length; i++) {
      items.add(new Item(name[i], quantity[i], price[i], calories[i]));
    }
  }

  /**
   * Retrieves the number of items in the slot.
   *
   * @return The number of items in the slot.
   */
  public int getNumberOfItems() {
    return items.size();
  }

  /**
   * Retrieves the list of items present in the slot.
   *
   * @return An ArrayList containing the items present in the slot.
   */
  public ArrayList<Item> getItems() {
    return items;
  }
}
