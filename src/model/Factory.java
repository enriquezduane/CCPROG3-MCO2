package model;

import java.util.ArrayList;

import model.VM.NormalVM;
import model.VM.SpecialVM;
import model.core.*;

public class Factory {
  private boolean isCreated;
  private boolean isSpecial;
  private NormalVM normalVM;
  private SpecialVM specialVM;

  public Factory() {
    isCreated = false;
    isSpecial = false;
    normalVM = new NormalVM();
  }

  public boolean getIsCreated() {
    return isCreated;
  }

  public void setIsCreated(boolean isCreated) {
    this.isCreated = isCreated;
  }

  public void addItemsInVendingMachine(String[] name, int[] quantity, int[] price, double[] calories) {
    int summaryQuantity = 0;

    for (int i = 0; i < calories.length; i++) {
      summaryQuantity += quantity[i];
    }

    normalVM.getTransactionSummary().addStartingInventory(summaryQuantity);
    normalVM.getTransactionSummary().addEndingInventory(summaryQuantity);
    normalVM.getSlots().add(new ItemSlot(name, quantity, price, calories));
  }

  public int getNumSlots() {
    return normalVM.getSlots().size();
  }

  public Currency getInsertedCurrency() {
    if (isSpecial == true) {
      return specialVM.getInsertedCurrency();
    } else {
      return normalVM.getInsertedCurrency();
    }
  }

  public Currency getMachineCurrency() {
    if (isSpecial == true) {
      return specialVM.getMachineCurrency();
    } else {
      return normalVM.getMachineCurrency();
    }
  }

  public Currency getPendingCurrency() {
    if (isSpecial == true) {
      return specialVM.getPendingCurrency();
    } else {
      return normalVM.getPendingCurrency();
    }
  }

  public Item[] getAllItems() {
    if (isSpecial == true) {
      return specialVM.getItems();
    } else {
      ArrayList<Item> placeholder = new ArrayList<>();
      for (ItemSlot itemSlot : normalVM.getSlots()) {
        for (Item item : itemSlot.getItems()) {
          placeholder.add(item);
        }
      }
      Item[] itemArray = placeholder.toArray(new Item[0]);
      return itemArray;
    }
  }

  public void clearData() {
    normalVM = new NormalVM();
  }

  public int buyItem(String itemName) {
    if (isSpecial == true) {
      Item item = specialVM.findItem(itemName);
      return specialVM.createTransaction(item);
    } else {
      Item item = normalVM.findItem(itemName);
      return normalVM.createTransaction(item);
    }
  }

  public void restockItem(String itemName, int amount) {

    if (isSpecial == true) {
      Item item = specialVM.findItem(itemName);
      item.setQuantity(item.getQuantity() + amount);
    } else {
      Item item = normalVM.findItem(itemName);
      item.setQuantity(item.getQuantity() + amount);
    }
  }

  public void changePrice(String itemName, int newPrice) {
    if (isSpecial == true) {
      Item item = specialVM.findItem(itemName);
      item.setPrice(newPrice);
    } else {
      Item item = normalVM.findItem(itemName);
      item.setPrice(newPrice);
    }
  }

  public void transferBalance() {
    if (isSpecial == true) {
      specialVM.transferBalance();
    } else {
      normalVM.transferBalance();
    }
  }

  public String getTransaction() {
    if (isSpecial == true) {
      return specialVM.buildTransactionSummary();
    } else {
      return normalVM.buildTransactionSummary();
    }
  }

  public void createSpecialVM() {
    specialVM = new SpecialVM();
    isCreated = true;
    isSpecial = true;
    specialVM.setSummary();
  }
}