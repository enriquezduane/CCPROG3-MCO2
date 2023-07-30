package model;

import java.util.ArrayList;

import model.VM.NormalVM;
import model.core.*;

public class Factory {
  private boolean isCreated;
  private NormalVM normalVM;

  public Factory() {
    isCreated = false;
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
    return normalVM.getInsertedCurrency();
  }

  public Currency getMachineCurrency() {
    return normalVM.getMachineCurrency();
  }

  public Currency getPendingCurrency() {
    return normalVM.getPendingCurrency();
  }

  public Item[] getAllItems() {
    ArrayList<Item> placeholder = new ArrayList<>();
    for (ItemSlot itemSlot : normalVM.getSlots()) {
      for (Item item : itemSlot.getItems()) {
        placeholder.add(item);
      }
    }
    Item[] itemArray = placeholder.toArray(new Item[0]);
    return itemArray;
  }

  public void clearData() {
    normalVM = new NormalVM();
  }

  public void buyItem(String itemName) {
    Item item = normalVM.findItem(itemName);
    normalVM.createTransaction(item);
  }

  public void restockItem(String itemName, int amount) {
    Item item = normalVM.findItem(itemName);
    item.setQuantity(item.getQuantity() + amount);
  }

  public void changePrice(String itemName, int newPrice) {
    Item item = normalVM.findItem(itemName);
    item.setPrice(newPrice);
  }

  public void transferBalance() {
    normalVM.transferBalance();
  }

  public String getTransaction() {
    return normalVM.buildTransactionSummary();
  }
}