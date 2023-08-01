package model.VM;

import java.util.ArrayList;

import model.VM.special.SpecialItems;
import model.VM.special.SpecialItems.*;
import model.core.*;

/**
 * The SpecialVM class represents a special vending machine with unique items and features.
 * It extends the abstract VendingMachine class and provides methods for managing special items and balances.
 */

public class SpecialVM extends VendingMachine {
  SpecialItems specialItems;
  SpecialItems.Beef beef;
  SpecialItems.Pork pork;
  SpecialItems.Tofu tofu;
  SpecialItems.Mushrooms mushrooms;
  SpecialItems.Cabbage cabbage;
  SpecialItems.ThaiChillies thaiChillies;
  SpecialItems.Sausage sausage;
  SpecialItems.Kimchi kimchi;
  Item sichuan;
  Item shabu;
  Item tom;
  Item budae;
  Item mongolian;
  Item vietnamese;

  /**
   * Constructs a new SpecialVM instance with its initial state.
   * It initializes the machine balances, transaction processor, and transaction summary.
   * It also creates instances of special items available in the special vending machine.
   */
  public SpecialVM() {
    this.machineBalance = new Currency();
    this.insertedBalance = new Currency();
    this.pendingBalance = new Currency();
    this.transactionProcessor = new TransactionProcessor();
    this.summary = new Transaction();

    this.specialItems = new SpecialItems();
    this.beef = specialItems.new Beef();
    this.pork = specialItems.new Pork();
    this.tofu = specialItems.new Tofu();
    this.mushrooms = specialItems.new Mushrooms();
    this.cabbage = specialItems.new Cabbage();
    this.thaiChillies = specialItems.new ThaiChillies();
    this.sausage = specialItems.new Sausage();
    this.kimchi = specialItems.new Kimchi();

    this.sichuan = new Item("!! Sichuan Hot Pot", 31, 45, 635);
    this.shabu = new Item("!! Sichuan Hot Pot", 31, 45, 635);
    this.tom = new Item("!! Tom Yum Hot Pot", 52, 28, 220);
    this.budae = new Item("!! Budae Jjigae", 9, 25, 595);
    this.mongolian = new Item("!! Mongolian Hot Pot", 19, 32, 645);
    this.vietnamese = new Item("!! Vietnamese Hot Pot", 21, 20, 530);
  }

   /**
   * Returns an array of all items available in the special vending machine.
   *
   * @return an array of special items available in the special vending machine.
   */

  public Item[] getItems() {
    ArrayList<Item> itemsList = new ArrayList<>();

    itemsList.add(sichuan);
    itemsList.add(shabu);
    itemsList.add(tom);
    itemsList.add(budae);
    itemsList.add(mongolian);
    itemsList.add(vietnamese);

    itemsList.add(beef);
    itemsList.add(pork);
    itemsList.add(tofu);
    itemsList.add(mushrooms);
    itemsList.add(cabbage);
    itemsList.add(thaiChillies);
    itemsList.add(sausage);
    itemsList.add(kimchi);

    return itemsList.toArray(new Item[0]);
  }

  
  /**
   * Sets the transaction summary's starting and ending inventory based on the quantities of special items.
   * It should be called after restocking special items to update the inventory.
   */
  public void setSummary() {
    int inventory = 0;
    for (Item item : this.getItems()) {
      inventory += item.getQuantity();
    }
    summary.setEndingInventory(inventory);
    summary.setStartingInventory(inventory);
  }

  /**
   * Finds a special item in the special vending machine based on the item name or a query.
   *
   * @param itemQuery the name or a part of the name of the item to search for.
   * @return the first matching special item found, or null if not found.
   */
  public Item findItem(String itemQuery) {
    for (Item item : this.getItems()) {
      if (item.getName().contains(itemQuery)) {
        return item;
      }
    }
    return null;
  }

   /**
   * Returns the Beef special item in the special vending machine.
   *
   * @return the Beef special item.
   */
  public Beef getBeef() {
    return beef;
  }

  /**
   * Returns the Pork special item in the special vending machine.
   *
   * @return the Pork special item.
   */

  public Pork getPork() {
    return pork;
  }

   /**
   * Returns the Tofu special item in the special vending machine.
   *
   * @return the Tofu special item.
   */
  public Tofu getTofu() {
    return tofu;
  }

/**
   * Returns the Mushrooms special item in the special vending machine.
   *
   * @return the Mushrooms special item.
   */
  public Mushrooms getMushrooms() {
    return mushrooms;
  }

  /**
   * Returns the Cabbage special item in the special vending machine.
   *
   * @return the Cabbage special item.
   */
  public Cabbage getCabbage() {
    return cabbage;
  }

 /**
   * Returns the ThaiChillies special item in the special vending machine.
   *
   * @return the ThaiChillies special item.
   */ 
  public ThaiChillies getThaiChillies() {
    return thaiChillies;
  }

  /**
   * Returns the Sausage special item in the special vending machine.
   *
   * @return the Sausage special item.
   */
  public Sausage getSausage() {
    return sausage;
  }

  /**
   * Returns the Kimchi special item in the special vending machine.
   *
   * @return the Kimchi special item.
   */
  public Kimchi getKimchi() {
    return kimchi;
  }
}
