public class Main {
  public static void main(String[] args) {
    NormalVendingMachine vend = new NormalVendingMachine();

    vend.addItemSlot();
    vend.addItemInVendingMachine("Lugaw", 12, 1.2, 100.2);
    vend.addItemInVendingMachine("Siomai", 14, 3.6, 12.2);
    vend.printItemDetails();

  }

}