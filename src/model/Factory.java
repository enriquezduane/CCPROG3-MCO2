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

  public void insertPresetItems() {
  }

  public void addItemsInVendingMachine(String[] name, int[] quantity, int[] price, double[] calories) {
    normalVM.getSlots().add(new ItemSlot(name, quantity, price, calories));
  }

  public int getNumSlots() {
    return normalVM.getSlots().size();
  }

  public Currency getInsertedCurrency() {
    return normalVM.getInsertedCurrency();
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
}