import java.util.ArrayList;

public class Factory {
  private ArrayList<NormalVendingMachine> vend;

  public Factory() {
    vend = new ArrayList<>();
  }

  public NormalVendingMachine getMostRecentVend() {
    return vend.get(vend.size() - 1);
  }

  public void createVendingMachine() {
    vend.add(new NormalVendingMachine());
  }

  public void showAllItems() {
    int i;
    for (i = 0; i < getMostRecentVend().getNumberOfSlots(); i++) {
      System.out.println("Slot #" + (i + 1));
      getMostRecentVend().displayItemsFromSlotIndex(i);
      System.out.println("");
    }
  }

  // TODO
  public boolean buyItem(String item) {
    int i, j;
    // if item found, then create transaction (boolean)
    for (i = 0; i < getMostRecentVend().getNumberOfSlots(); i++) {
      for (j = 0; j < getMostRecentVend().getNumberOfItemsPerSlot(i); j++) {
        if (getMostRecentVend().getSlots().get(i).getItems().get(j).getName().contains(item)) {
          return getMostRecentVend().createTransaction(i, j, item);
        }
      }
    }
    return false;
  }

  public void restock(String item, int qty) {
    int i, j;
    for (i = 0; i < getMostRecentVend().getNumberOfSlots(); i++) {
      for (j = 0; j < getMostRecentVend().getNumberOfItemsPerSlot(i); j++) {
        if (getMostRecentVend().getSlots().get(i).getItems().get(j).getName().contains(item)) {
          getMostRecentVend().getSlots().get(i).getItems().get(j).replenishQuantity(qty);
        }
      }
    }
  }

  public void changePrice(String item, int price) {
    int i, j;
    for (i = 0; i < getMostRecentVend().getNumberOfSlots(); i++) {
      for (j = 0; j < getMostRecentVend().getNumberOfItemsPerSlot(i); j++) {
        if (getMostRecentVend().getSlots().get(i).getItems().get(j).getName().contains(item)) {
          getMostRecentVend().getSlots().get(i).getItems().get(j).setPrice(price);
        }
      }
    }
  }

  public void createItemSlot(String name[], int quantity[], int price[], double calories[]) {
    int i;
    getMostRecentVend().addItemSlot();
    for (i = 0; i < name.length; i++) {
      getMostRecentVend().addItemInVendingMachine(name[i], quantity[i], price[i], calories[i]);
    }
  }

  public void insertMoney(int balance[]) {
    getMostRecentVend().getInsertedCurrency().replenishMoney(balance);
  }

  public void displayInsertedBalance() {
    System.out.println("1  : " + getMostRecentVend().getInsertedCurrency().getOne());
    System.out.println("5  : " + getMostRecentVend().getInsertedCurrency().getFive());
    System.out.println("10 : " + getMostRecentVend().getInsertedCurrency().getTen());
    System.out.println("20 : " + getMostRecentVend().getInsertedCurrency().getTwenty());
    System.out.println("50 : " + getMostRecentVend().getInsertedCurrency().getFifty());
    System.out.println("100: " + getMostRecentVend().getInsertedCurrency().getHundred());
  }

  public void displayVendingMachineBalance() {
    System.out.println("Current Vending Machine Balance: ");
    System.out.println("1  : " + getMostRecentVend().getMachineCurrency().getOne());
    System.out.println("5  : " + getMostRecentVend().getMachineCurrency().getFive());
    System.out.println("10 : " + getMostRecentVend().getMachineCurrency().getTen());
    System.out.println("20 : " + getMostRecentVend().getMachineCurrency().getTwenty());
    System.out.println("50 : " + getMostRecentVend().getMachineCurrency().getFifty());
    System.out.println("100: " + getMostRecentVend().getMachineCurrency().getHundred());
  }

  public void displayTransactionSummary() {
    // TODO (ITEMS)
    System.out.println(
        "Total Amount Collected From Sales: " + getMostRecentVend().getTransactionSummary().getTotalAmountFromSales());
    System.out.println("Starting Inventory: " + getMostRecentVend().getTransactionSummary().getStartingInventory());
    System.out.println("Ending Inventory: " + getMostRecentVend().getTransactionSummary().getEndingInventory());
  }

  // public buyItem()

}
