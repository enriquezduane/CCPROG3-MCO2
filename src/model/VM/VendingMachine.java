package model.VM;

import java.util.ArrayList;

import model.core.*;

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

  public boolean createTransaction(Item item) {
    int[] change = new int[3];
    int itemPrice = item.getPrice();
    int changeToBeProduced = insertedBalance.getTotalAmount() - itemPrice;

    // if quantity < 1
    if (item.getQuantity() == 0) {
      System.out.println("No more stock available.");
      return false;
    }

    // if inserted amount less than price of selected item
    if (insertedBalance.getTotalAmount() < itemPrice) {
      System.out.println("Insufficient amount inserted.");
      return false;
    }

    // if user inserted an amount greater than the product
    if (changeToBeProduced > 0) {
      // if cannot produce change
      if (!transactionProcessor.canProduceChange(machineBalance, changeToBeProduced)) {
        System.out.println("Machine has no balance.");
        return false;
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

    return true;
  }

  public void transferBalance() {
    int[] balance;
    balance = new int[6];

    balance[0] = pendingBalance.getOne();
    balance[1] = pendingBalance.getFive();
    balance[2] = pendingBalance.getTen();

    pendingBalance.reset();
    machineBalance.replenishMoney(balance);
  }
}
