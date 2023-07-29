package model.VM;

import java.util.ArrayList;

import model.core.*;

public class NormalVM extends VendingMachine {
  public NormalVM() {
    this.slots = new ArrayList<>();
    this.machineBalance = new Currency();
    this.insertedBalance = new Currency();
    this.pendingBalance = new Currency();
  }

  public Item getItem(String itemName) {
    for (ItemSlot itemSlot : slots) {
      for (Item item : itemSlot.getItems()) {
        if (item.getName().contains(itemName)) {
          return item;
        }
      }
    }
    return null;
  }

}
