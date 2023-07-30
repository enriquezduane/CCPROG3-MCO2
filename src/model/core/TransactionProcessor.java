package model.core;

// this class handles the transaction process
public class TransactionProcessor {
  // checks if the machine can produce change
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

    if (changeToBeReceived > 0) {
      return false;
    }

    return true;
  }

  // produces change. machine currency returns the changeToBeProduced in a int
  // array format to be processesed and given back to the user.
  public int[] produceChange(Currency machineCurrency, int changeToBeProduced) {
    int change[] = new int[3];

    int machineOne = machineCurrency.getOne();
    int machineFive = machineCurrency.getFive();
    int machineTen = machineCurrency.getTen();

    while (changeToBeProduced / 10 > 0 && machineTen > 0) {
      changeToBeProduced -= 10;
      machineCurrency.setTen(machineCurrency.getTen() - 1);
      change[2]++;
    }

    while (changeToBeProduced / 5 > 0 && machineFive > 0) {
      changeToBeProduced -= 5;
      machineCurrency.setFive(machineCurrency.getFive() - 1);
      change[1]++;
    }

    while (changeToBeProduced / 1 > 0 && machineOne > 0) {
      changeToBeProduced -= 1;
      machineCurrency.setOne(machineCurrency.getOne() - 1);
      change[0]++;
    }

    return change;
  }

  // accepts amount of the user. inserted balance will go to the pending balance
  public void acceptAmount(Currency pendingBalance, Currency insertedBalance) {
    int[] balance;
    balance = new int[3];

    balance[0] = insertedBalance.getOne();
    balance[1] = insertedBalance.getFive();
    balance[2] = insertedBalance.getTen();

    pendingBalance.replenishMoney(balance);
    insertedBalance.reset();
  }
}
