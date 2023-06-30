import java.util.ArrayList;

// class that is the foundation of the project
public class Factory {
  private ArrayList<NormalVendingMachine> vend;

  public Factory() {
    vend = new ArrayList<>();
  }

  // gets the most recent vend since the specs says we should only maintain the
  // most recent vending machine created
  public NormalVendingMachine getMostRecentVend() {
    return vend.get(vend.size() - 1);
  }

  // creates a vending machine
  public void createVendingMachine() {
    vend.add(new NormalVendingMachine());
  }

  // shows all the items in the vending machine
  public void showAllItems() {
    int i;
    for (i = 0; i < getMostRecentVend().getNumberOfSlots(); i++) {
      System.out.println("Slot #" + (i + 1));
      getMostRecentVend().displayItemsFromSlotIndex(i);
      System.out.println("");
    }
  }

  // finds item, and tries to buy it if it is found. if item not found, then
  // return false.
  public boolean buyItem(String item) {
    int i, j;
    for (i = 0; i < getMostRecentVend().getNumberOfSlots(); i++) {
      for (j = 0; j < getMostRecentVend().getNumberOfItemsPerSlot(i); j++) {
        if (getMostRecentVend().getSlots().get(i).getItems().get(j).getName().contains(item)) {
          return getMostRecentVend().createTransaction(i, j, item);
        }
      }
    }
    System.out.println("Item Not Found.");
    return false;
  }

  // restocks an item based from the given parameters
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

  // changes price of an item from the given parameters
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

  // creates an item slot with the items included
  public void createItemSlot(String name[], int quantity[], int price[], double calories[]) {
    int i;
    getMostRecentVend().addItemSlot();
    for (i = 0; i < name.length; i++) {
      getMostRecentVend().addItemInVendingMachine(name[i], quantity[i], price[i], calories[i]);
    }
  }

  // inserts money to the insertedCurrency
  public void insertMoney(int balance[]) {
    getMostRecentVend().getInsertedCurrency().replenishMoney(balance);
  }

  // displays the inserted balance
  public void displayInsertedBalance() {
    System.out.println("Current Inserted Balance: ");
    System.out.println("1  : " + getMostRecentVend().getInsertedCurrency().getOne());
    System.out.println("5  : " + getMostRecentVend().getInsertedCurrency().getFive());
    System.out.println("10 : " + getMostRecentVend().getInsertedCurrency().getTen());
    System.out.println("20 : " + getMostRecentVend().getInsertedCurrency().getTwenty());
    System.out.println("50 : " + getMostRecentVend().getInsertedCurrency().getFifty());
    System.out.println("100: " + getMostRecentVend().getInsertedCurrency().getHundred());
  }

  // transfers balance from pending currency -> machine currency
  public void transferBalance() {
    int[] balance;
    balance = new int[6];

    balance[0] = getMostRecentVend().getPendingCurrency().getOne();
    balance[1] = getMostRecentVend().getPendingCurrency().getFive();
    balance[2] = getMostRecentVend().getPendingCurrency().getTen();
    balance[3] = getMostRecentVend().getPendingCurrency().getTwenty();
    balance[4] = getMostRecentVend().getPendingCurrency().getFifty();
    balance[5] = getMostRecentVend().getPendingCurrency().getHundred();

    getMostRecentVend().getPendingCurrency().reset();
    getMostRecentVend().getMachineCurrency().replenishMoney(balance);
  }

  // displays the machine balance (denominations) of the vending machine
  public void displayVendingMachineBalance() {
    System.out.println("Current Vending Machine Balance: ");
    System.out.println("1  : " + getMostRecentVend().getMachineCurrency().getOne());
    System.out.println("5  : " + getMostRecentVend().getMachineCurrency().getFive());
    System.out.println("10 : " + getMostRecentVend().getMachineCurrency().getTen());
    System.out.println("20 : " + getMostRecentVend().getMachineCurrency().getTwenty());
    System.out.println("50 : " + getMostRecentVend().getMachineCurrency().getFifty());
    System.out.println("100: " + getMostRecentVend().getMachineCurrency().getHundred());
  }

  // displays the pending balance (denominations) of the vending machine
  public void displayPendingBalance() {
    System.out.println("Current Pending Balance: ");
    System.out.println("1  : " + getMostRecentVend().getPendingCurrency().getOne());
    System.out.println("5  : " + getMostRecentVend().getPendingCurrency().getFive());
    System.out.println("10 : " + getMostRecentVend().getPendingCurrency().getTen());
    System.out.println("20 : " + getMostRecentVend().getPendingCurrency().getTwenty());
    System.out.println("50 : " + getMostRecentVend().getPendingCurrency().getFifty());
    System.out.println("100: " + getMostRecentVend().getPendingCurrency().getHundred());
  }

  // displays the transaction summary
  public void displayTransactionSummary() {
    getMostRecentVend().displayTransactionSummary();
  }

}
