import java.util.ArrayList;

public class VendingMachine {
  private static int numVendingMachine;
  private ArrayList<ItemSlot> slots;
  private Currency currency;

  public VendingMachine() {
    slots = new ArrayList<>();
    this.currency = new Currency();
    numVendingMachine += 1;
  }

}
