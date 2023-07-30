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
  }

  public Item[] getItems() {
    ArrayList<Item> itemsList = new ArrayList<>();

    itemsList.add(new Item("!! Sichuan Hot Pot", 31, 45, 635));
    itemsList.add(new Item("!! Shabu-Shabu Hot Pot", 12, 49, 455));
    itemsList.add(new Item("!! Tom Yum Hot Pot", 52, 28, 220));
    itemsList.add(new Item("!! Budae Jjigae", 9, 25, 595));
    itemsList.add(new Item("!! Mongolian Hot Pot", 19, 32, 645));
    itemsList.add(new Item("!! Vietnamese Hot Pot", 21, 20, 530));

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
