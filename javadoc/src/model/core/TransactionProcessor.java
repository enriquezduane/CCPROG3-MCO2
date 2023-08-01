package model.core;

/**
 * The TransactionProcessor class handles the transaction process in the vending machine application. It contains
 * methods for checking if the machine can produce change, producing change in the form of coins, and accepting
 * amounts from the user and updating the pending balance.
 */
public class TransactionProcessor {

  /**
   * Checks if the vending machine can produce change for the given amount.
   *
   * @param machineCurrency The Currency object representing the vending machine's available currency.
   * @param changeToBeReceived The amount of change to be received.
   * @return true if the machine can produce the required change, false otherwise.
   */
  public boolean canProduceChange(Currency machineCurrency, int changeToBeReceived) {
    int machineOne = machineCurrency.getOne();
    int machineFive = machineCurrency.getFive();
    int machineTen = machineCurrency.getTen();

    while (changeToBeReceived / 10 > 0 && machineTen > 0) {
      changeToBeReceived -= 10;
      machineTen--;
    }

    while (changeToBeReceived / 5 > 0 && machineFive > 0) {
      changeToBeReceived -= 5;
      machineFive--;
    }

    while (changeToBeReceived / 1 > 0 && machineOne > 0) {
      changeToBeReceived -= 1;
      machineOne--;
    }

    return changeToBeReceived == 0;
  }

  /**
   * Produces change for the given amount and updates the machine currency accordingly.
   *
   * @param machineCurrency The Currency object representing the vending machine's available currency.
   * @param changeToBeProduced The amount of change to be produced.
   * @return An array of integers representing the coins used to produce the change, with counts for one, five, and ten
   *         currency units respectively.
   */
  public int[] produceChange(Currency machineCurrency, int changeToBeProduced) {
    int change[] = new int[3];

    int machineOne = machineCurrency.getOne();
    int machineFive = machineCurrency.getFive();
    int machineTen = machineCurrency.getTen();

    while (changeToBeProduced / 10 > 0 && machineTen > 0) {
      changeToBeProduced -= 10;
      machineCurrency.setTen(machineTen - 1);
      change[2]++;
    }

    while (changeToBeProduced / 5 > 0 && machineFive > 0) {
      changeToBeProduced -= 5;
      machineCurrency.setFive(machineFive - 1);
      change[1]++;
    }

    while (changeToBeProduced / 1 > 0 && machineOne > 0) {
      changeToBeProduced -= 1;
      machineCurrency.setOne(machineOne - 1);
      change[0]++;
    }

    return change;
  }

  /**
   * Accepts the amount from the user and updates the pending balance.
   *
   * @param pendingBalance The Currency object representing the pending balance of the vending machine.
   * @param insertedBalance The Currency object representing the balance inserted by the user.
   */
  public void acceptAmount(Currency pendingBalance, Currency insertedBalance) {
    int[] balance = new int[3];
    balance[0] = insertedBalance.getOne();
    balance[1] = insertedBalance.getFive();
    balance[2] = insertedBalance.getTen();

    pendingBalance.replenishMoney(balance);
    insertedBalance.reset();
  }
}
