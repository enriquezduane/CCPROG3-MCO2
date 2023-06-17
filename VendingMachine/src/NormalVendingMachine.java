import java.util.ArrayList;

public class NormalVendingMachine {
  private ArrayList<ItemSlot> slots;
  private Currency balance;
  private Currency pending;

  public NormalVendingMachine() {
    slots = new ArrayList<>();
    this.balance = new Currency();
    this.pending = new Currency();
  }

  public void addItemSlot() {
    slots.add(new ItemSlot());
  }

  public int getNumberOfSlots() {
    return slots.size();
  }

  public void addItemInVendingMachine(String name, int quantity, Double price, Double calories) {
    slots.get(slots.size() - 1).addItem(name, quantity, price, calories);
  }

  public void printItemDetails() {
    for (int i = 0; i < slots.get(0).items.size(); i++)
      System.out.println(slots.get(0).items.get(i));
  }

  public int getPendingMoney() {
    return pending.getTotalAmount();
  }

  public int getNormalVendingMachineBalance() {
    return balance.getTotalAmount();
  }
}
