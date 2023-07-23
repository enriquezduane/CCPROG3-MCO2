package model.core;

import java.util.ArrayList;

public class ItemSlot {
  private ArrayList<Item> items;

  public ItemSlot(String[] name, int[] quantity, int[] price, double[] calories) {
    items = new ArrayList<>();
    int i;
    for (i = 0; i < name.length; i++) {
      items.add(new Item(name[i], quantity[i], price[i], calories[i]));
    }
  }

  public int getNumberOfItems() {
    return items.size();
  }

  public ArrayList<Item> getItems() {
    return items;
  }
}
