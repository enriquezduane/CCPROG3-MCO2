package model.core;

import java.util.ArrayList;

public class ItemSlot {
  private ArrayList<Item> items;

  public int getNumberOfItems() {
    return items.size();
  }

  public ArrayList<Item> getItems() {
    return items;
  }
}
