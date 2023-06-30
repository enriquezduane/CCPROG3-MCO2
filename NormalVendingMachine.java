import java.util.ArrayList;

public class NormalVendingMachine {
  private ArrayList<ItemSlot> slots;
  private Currency machineBalance;
  private Currency insertedBalance;
  private Currency pendingBalance;
  private Transaction summary;
  private TransactionProcessor transactionProcessor;

  public NormalVendingMachine() {
    slots = new ArrayList<>();
    machineBalance = new Currency();
    insertedBalance = new Currency();
    pendingBalance = new Currency();
    summary = new Transaction();
    transactionProcessor = new TransactionProcessor();
  }

  public TransactionProcessor getTransactionProcessor() {
    return transactionProcessor;
  }

  public void addItemInVendingMachine(String name, int quantity, int price, Double calories) {
    slots.get(slots.size() - 1).addItem(name, quantity, price, calories);
  }

  public boolean createTransaction(int slotIndex, int itemIndex, String item) {
    int[] change = new int[6];
    int itemPrice = slots.get(slotIndex).getItems().get(itemIndex).getPrice();
    int changeToBeProduced = insertedBalance.getTotalAmount() - itemPrice;

    // if quantity < 1
    if (slots.get(slotIndex).items.get(itemIndex).getQuantity() == 0) {
      return false;
    }

    // if inserted amount less than price of selected item
    if (insertedBalance.getTotalAmount() < itemPrice) {
      return false;
    }

    if (changeToBeProduced > 0) {
      // if cannot produce change
      if (!transactionProcessor.canProduceChange(machineBalance, changeToBeProduced)) {
        return false;
      }
    }

    transactionProcessor.acceptAmount(pendingBalance, insertedBalance);

    if (changeToBeProduced > 0) {
      change = transactionProcessor.produceChange(machineBalance, changeToBeProduced);
    }

    insertedBalance.replenishMoney(change);

    slots.get(slotIndex).items.get(itemIndex).deductQuantity();
    summary.deductEndingInventory();
    summary.updateTotalAmountFromSales(slots.get(slotIndex).getItems().get(itemIndex).getPrice());
    summary.addItem(slots.get(slotIndex).items.get(itemIndex));

    return true;
  }

  public int getNumberOfSlots() {
    return slots.size();
  }

  public int getNumberOfItemsPerSlot(int index) {
    return slots.get(index).getNumberOfItems();
  }

  public ArrayList<Item> getItemsFromSlot(int index) {
    return slots.get(index).getItems();
  }

  public void displayItemsFromSlotIndex(int index) {
    slots.get(index).displayItems();
  }

  public void displayTransactionSummary() {
    int i;
    for (i = 0; i < summary.getItems().size(); i++) {
      System.out.println("Item Name:" + summary.getItems().get(i).getName());
      System.out.println("Item Quantity:" + summary.getItems().get(i).getQuantity());
    }
    System.out.println("Total Amount Collected" + summary.getTotalAmountFromSales());
    System.out.println("Starting Inventory" + summary.getStartingInventory());
    System.out.println("Ending Inventory" + summary.getEndingInventory());
  }

  public Currency getMachineCurrency() {
    return machineBalance;
  }

  public Currency getPendingCurrency() {
    return pendingBalance;
  }

  public Currency getInsertedCurrency() {
    return insertedBalance;
  }

  public int getMachineBalance() {
    return machineBalance.getTotalAmount();
  }

  public int getInsertedBalance() {
    return insertedBalance.getTotalAmount();
  }

  public Transaction getTransactionSummary() {
    return summary;
  }

  public ArrayList<ItemSlot> getSlots() {
    return slots;
  }

  public void addItemSlot() {
    slots.add(new ItemSlot());
  }

}
