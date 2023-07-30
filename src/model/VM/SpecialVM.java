package model.VM;

import java.util.ArrayList;

import model.VM.special.SpecialItems;
import model.VM.special.SpecialItems.*;
import model.core.*;

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
    itemsList.add(sausage);
    itemsList.add(kimchi);

    return itemsList.toArray(new Item[0]);
  }

  public void setSummary() {
    int inventory = 0;
    for (Item item : this.getItems()) {
      inventory += item.getQuantity();
    }
    summary.setEndingInventory(inventory);
    summary.setStartingInventory(inventory);
  }

  public Item findItem(String itemQuery) {
    for (Item item : this.getItems()) {
      if (item.getName().contains(itemQuery)) {
        return item;
      }
    }
    return null;
  }

  public Beef getBeef() {
    return beef;
  }

  public Pork getPork() {
    return pork;
  }

  public Tofu getTofu() {
    return tofu;
  }

  public Mushrooms getMushrooms() {
    return mushrooms;
  }

  public Cabbage getCabbage() {
    return cabbage;
  }

  public ThaiChillies getThaiChillies() {
    return thaiChillies;
  }

  public Sausage getSausage() {
    return sausage;
  }

  public Kimchi getKimchi() {
    return kimchi;
  }
}
