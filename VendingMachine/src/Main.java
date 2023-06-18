public class Main {
  public static void main(String[] args) {
    NormalVendingMachine vend = new NormalVendingMachine();
    Currency currency = new Currency();
    // TESTING LANG
    // vend.addItemSlot();
    // vend.addItemInVendingMachine("Lugaw", 12, 1.2, 100.2);
    // vend.addItemInVendingMachine("Siomai", 14, 3.6, 12.2);
    // vend.printItemDetails();
    System.out.println(vend.getNumberOfSlots());
    vend.getBalance().replenishMoney(0, 0, 0, 4);
    currency.replenishMoney(0, 0, 0, 4);
    System.out.println("vending machine balance: " + vend.getNormalVendingMachineBalance());
    System.out.println("vending machine balance: " + currency.getTotalAmount());

  }

}