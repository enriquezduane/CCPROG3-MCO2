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
    vend.addNormalVendingMachineBalance(1, 2, 3, 4);
    // (4 * 1000) + (3 * 100) + (2 * 10) + (1 * 1)
    // 4321
    System.out.println("vending machine balance: " + vend.getNormalVendingMachineBalance());

  }

}