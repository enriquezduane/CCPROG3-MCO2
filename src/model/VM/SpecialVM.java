package model.VM;

import java.util.ArrayList;

import model.VM.special.SpecialItems;
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

  SpecialVM() {
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

}
