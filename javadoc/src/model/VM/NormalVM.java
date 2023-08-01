package model.VM;

import java.util.ArrayList;

import model.core.*;

/**
 * The NormalVM class represents a normal vending machine.
 * It extends the abstract VendingMachine class and provides methods for managing normal items and balances.
 */

public class NormalVM extends VendingMachine {
  
  /**
   * Constructs a new NormalVM instance with its initial state.
   * It initializes the list of item slots, machine balances, transaction processor, and transaction summary.
   */
  public NormalVM() {
    this.slots = new ArrayList<>();
    this.machineBalance = new Currency();
    this.insertedBalance = new Currency();
    this.pendingBalance = new Currency();
    this.transactionProcessor = new TransactionProcessor();
    this.summary = new Transaction();
  }

}
