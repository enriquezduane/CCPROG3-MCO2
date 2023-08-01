package model;

import java.util.ArrayList;

import model.VM.NormalVM;
import model.VM.SpecialVM;
import model.core.*;

/**
 * The Factory class represents a factory for creating and managing vending machines.
 * It provides methods for adding items, buying items, restocking items, and more.
 */

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

  
  /**
   * Adds items to the vending machine's slots.
   *
   * @param name     an array of item names.
   * @param quantity an array of item quantities.
   * @param price    an array of item prices.
   * @param calories an array of item calories.
   */

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

  /**
   * Returns the currently inserted currency in the vending machine.
   * If a special vending machine is active, it returns the currency from the special vending machine.
   * Otherwise, it returns the currency from the normal vending machine.
   *
   * @return the currently inserted currency.
   */

  public Currency getInsertedCurrency() {
    if (isSpecial == true) {
      return specialVM.getInsertedCurrency();
    } else {
      return normalVM.getInsertedCurrency();
    }
  }

  /**
   * Returns the total currency present in the vending machine.
   * If a special vending machine is active, it returns the currency from the special vending machine.
   * Otherwise, it returns the currency from the normal vending machine.
   *
   * @return the total currency present in the vending machine.
   */
  public Currency getMachineCurrency() {
    if (isSpecial == true) {
      return specialVM.getMachineCurrency();
    } else {
      return normalVM.getMachineCurrency();
    }
  }

  
  /**
   * @return the pending currency.
   */
  public Currency getPendingCurrency() {
    if (isSpecial == true) {
      return specialVM.getPendingCurrency();
    } else {
      return normalVM.getPendingCurrency();
    }
  }

   /**
   * Returns an array of all items present in the vending machine.
   * If a special vending machine is active, it returns the items from the special vending machine.
   * Otherwise, it returns the items from the normal vending machine, aggregating all slots.
   *
   * @return an array of all items present in the vending machine.
   */

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

  // Clears all data in the current Vending Machine
  public void clearData() {
    normalVM = new NormalVM();
  }

   /**
   * Buys an item from the vending machine with the specified item name.
   * @param itemName the name of the item to buy.
   * @return the transaction result.
   */

  public int buyItem(String itemName) {
    if (isSpecial == true) {
      Item item = specialVM.findItem(itemName);
      return specialVM.createTransaction(item);
    } else {
      Item item = normalVM.findItem(itemName);
      return normalVM.createTransaction(item);
    }
  }

    /**
   * Restocks an item in the vending machine with the specified item name.
   * @param itemName the name of the item to restock.
   * @param amount  the quantity to add to the item's stock.
   */
  public void restockItem(String itemName, int amount) {

    if (isSpecial == true) {
      Item item = specialVM.findItem(itemName);
      item.setQuantity(item.getQuantity() + amount);
    } else {
      Item item = normalVM.findItem(itemName);
      item.setQuantity(item.getQuantity() + amount);
    }
  }

    /**
   * Changes the price of an item in the vending machine with the specified item name.
   * @param itemName the name of the item to change the price of.
   * @param newPrice the new price of the item.
   */
  public void changePrice(String itemName, int newPrice) {
    if (isSpecial == true) {
      Item item = specialVM.findItem(itemName);
      item.setPrice(newPrice);
    } else {
      Item item = normalVM.findItem(itemName);
      item.setPrice(newPrice);
    }
  }

  /**
   * Transfers the pending currency to the vending machine balance.
   */
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