package model.VM;

import java.util.ArrayList;

import model.core.*;

public abstract class VendingMachine {
  private ArrayList<ItemSlot> slots;
  private Currency machineBalance;
  private Currency insertedBalance;
  private Currency PendingBalance;

  public int getNumberOfSlots() {
    return slots.size();
  }

  public int getNumberOfItemsInSlot(int i) {
    return slots.get(i).getNumberOfItems();
  }

  public Item findItem(String itemQuery) {
    for (ItemSlot itemSlot : slots) {
      for (Item item : itemSlot.getItems()) {
        if (item.getName().contains(itemQuery)) {
          return item;
        }
      }
    }
    return null;
  }
}
