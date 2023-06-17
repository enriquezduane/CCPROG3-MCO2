import java.util.ArrayList;

public class VendingMachine {
  private ArrayList<ItemSlot> slots;
  private Currency currency;

  public VendingMachine() {
    slots = new ArrayList<>();
    this.currency = new Currency();
  }

  public int getCurrency() {
    return currency.getTotalAmount();
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

}
