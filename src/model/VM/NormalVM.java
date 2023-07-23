package model.VM;

import java.util.ArrayList;

import model.core.*;

public class NormalVM extends VendingMachine {
  public NormalVM() {
    this.slots = new ArrayList<>();
    this.machineBalance = new Currency();
    this.insertedBalance = new Currency();
    this.pendingBalance = new Currency();
  }
}
