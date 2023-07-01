import java.util.ArrayList;

// blueprint for a normal vending machine, contains the necessary
public class NormalVendingMachine {
  private ArrayList<ItemSlot> slots;
  private Currency machineBalance;
  private Currency insertedBalance;
  private Currency pendingBalance;
  private Transaction summary;
  private TransactionProcessor transactionProcessor;

  // constructor that initializes everything
  public NormalVendingMachine() {
    slots = new ArrayList<>();
    machineBalance = new Currency();
    insertedBalance = new Currency();
    pendingBalance = new Currency();
    summary = new Transaction();
    transactionProcessor = new TransactionProcessor();
  }

  // getter for TransactionProcessor
  public TransactionProcessor getTransactionProcessor() {
    return transactionProcessor;
  }

  // passes the item to add item
  public void addItemInVendingMachine(String name, int quantity, int price, Double calories) {
    slots.get(slots.size() - 1).addItem(name, quantity, price, calories);
  }

  // creates a transaction. returns true if transaction is feasable
  public boolean createTransaction(int slotIndex, int itemIndex, String item) {
    int[] change = new int[6];
    int itemPrice = slots.get(slotIndex).getItems().get(itemIndex).getPrice();
    int changeToBeProduced = insertedBalance.getTotalAmount() - itemPrice;

    // if quantity < 1
    if (slots.get(slotIndex).items.get(itemIndex).getQuantity() == 0) {
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

    slots.get(slotIndex).items.get(itemIndex).deductQuantity();
    summary.deductEndingInventory();
    summary.updateTotalAmountFromSales(slots.get(slotIndex).getItems().get(itemIndex).getPrice());
    summary.addItem(slots.get(slotIndex).items.get(itemIndex));

    return true;
  }

  // gets the number of slots in the machine
  public int getNumberOfSlots() {
    return slots.size();
  }

  // gets the number of items inside a slot from a specified index
  public int getNumberOfItemsPerSlot(int index) {
    return slots.get(index).getNumberOfItems();
  }

  // gets all the items from the slot
  public ArrayList<Item> getItemsFromSlot(int index) {
    return slots.get(index).getItems();
  }

  // displays items
  public void displayItemsFromSlotIndex(int index) {
    slots.get(index).displayItems();
  }

  // displays the transaction summary
  public void displayTransactionSummary() {
    int i;

    for (i = 0; i < summary.getItems().size(); i++) {
      System.out.println("Item Name:" + summary.getItems().get(i).getName());
      System.out.println("Item Quantity: " + summary.getItems().get(i).getQuantity() + "\n");
    }

    System.out.println("Total Amount Collected: " + summary.getTotalAmountFromSales());
    System.out.println("Starting Inventory: " + summary.getStartingInventory());
    System.out.println("Ending Inventory: " + summary.getEndingInventory());
  }

  // gets the machine currency
  public Currency getMachineCurrency() {
    return machineBalance;
  }

  // gets the pending currency
  public Currency getPendingCurrency() {
    return pendingBalance;
  }

  // gets the inserted currency
  public Currency getInsertedCurrency() {
    return insertedBalance;
  }

  // gets the balance of the machine
  public int getMachineBalance() {
    return machineBalance.getTotalAmount();
  }

  // gets the balance of the inserted amount from the user
  public int getInsertedBalance() {
    return insertedBalance.getTotalAmount();
  }

  // gets the transaction summary
  public Transaction getTransactionSummary() {
    return summary;
  }

  // gets the slots of the items
  public ArrayList<ItemSlot> getSlots() {
    return slots;
  }

  // gets the slots of the items
  public void addItemSlot() {
    slots.add(new ItemSlot());
  }

}
