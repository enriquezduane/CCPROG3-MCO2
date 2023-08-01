package model.VM;

import java.util.ArrayList;

import model.core.*;

/**
 * The VendingMachine abstract class represents a general vending machine.
 * It provides common functionalities and properties for both NormalVM and SpecialVM.
 */

public abstract class VendingMachine {
  protected ArrayList<ItemSlot> slots;
  protected Currency machineBalance;
  protected Currency insertedBalance;
  protected Currency pendingBalance;
  protected Transaction summary;
  protected TransactionProcessor transactionProcessor;

  public ArrayList<ItemSlot> getSlots() {
    return slots;
  }

  public Currency getInsertedCurrency() {
    return insertedBalance;
  }

  public Currency getPendingCurrency() {
    return pendingBalance;
  }

  public Currency getMachineCurrency() {
    return machineBalance;
  }

  public Transaction getTransactionSummary() {
    return summary;
  }

  /**
   * Returns the number of items in the specified slot.
   *
   * @param i the index of the slot.
   * @return the number of items in the specified slot.
   */

  public int getNumberOfItemsInSlot(int i) {
    return slots.get(i).getNumberOfItems();
  }

   /**
   * Finds an item in the vending machine based on the item name or a query.
   *
   * @param itemQuery the name or a part of the name of the item to search for.
   * @return the first matching item found in the vending machine, or null if not found.
   */
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

    /**
   * Processes a transaction for buying an item from the vending machine.
   *
   * @param item the item to be purchased.
   * @return the transaction result.
   */

  public int createTransaction(Item item) {
    int[] change = new int[3];
    int itemPrice = item.getPrice();
    int changeToBeProduced = insertedBalance.getTotalAmount() - itemPrice;

    // if quantity < 1
    if (item.getQuantity() == 0) {
      return 1;
    }

    // if inserted amount less than price of selected item
    if (insertedBalance.getTotalAmount() < itemPrice) {
      return 2;
    }

    // if user inserted an amount greater than the product
    if (changeToBeProduced > 0) {
      // if cannot produce change
      if (!transactionProcessor.canProduceChange(machineBalance, changeToBeProduced)) {
        return 3;
      }
    }

    transactionProcessor.acceptAmount(pendingBalance, insertedBalance);

    if (changeToBeProduced > 0) {
      change = transactionProcessor.produceChange(machineBalance, changeToBeProduced);
    }

    insertedBalance.replenishMoney(change);

    item.setQuantity(item.getQuantity() - 1);
    summary.deductEndingInventory();
    summary.updateTotalAmountFromSales(item.getPrice());
    summary.addItem(item);
    return 0;
  }

  /**
   * Transfers the pending currency to the vending machine balance.
   */
  public void transferBalance() {
    int[] balance;
    balance = new int[6];

    balance[0] = pendingBalance.getOne();
    balance[1] = pendingBalance.getFive();
    balance[2] = pendingBalance.getTen();

    pendingBalance.reset();
    machineBalance.replenishMoney(balance);
  }

   /**
   * Builds a textual representation of the transaction summary.
   *
   * @return a string containing the details of the transaction summary.
   */
  public String buildTransactionSummary() {
    StringBuilder summaryText = new StringBuilder();

    for (int i = 0; i < summary.getItems().size(); i++) {
      summaryText.append("Item Name: ").append(summary.getItems().get(i).getName()).append("\n");
      summaryText.append("Item Quantity: ").append(summary.getItems().get(i).getQuantity()).append("\n\n");
    }

    summaryText.append("Total Amount Collected: ").append(summary.getTotalAmountFromSales()).append("\n");
    summaryText.append("Starting Inventory: ").append(summary.getStartingInventory()).append("\n");
    summaryText.append("Ending Inventory: ").append(summary.getEndingInventory());

    return summaryText.toString();
  }
}
