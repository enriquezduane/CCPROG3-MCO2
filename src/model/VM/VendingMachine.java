package model.VM;

import java.util.ArrayList;

import model.core.*;

public abstract class VendingMachine {
  protected ArrayList<ItemSlot> slots;
  protected Currency machineBalance;
  protected Currency insertedBalance;
  protected Currency pendingBalance;

  public ArrayList<ItemSlot> getSlots() {
    return slots;
  }

  public Currency getInsertedCurrency() {
    return insertedBalance;
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
