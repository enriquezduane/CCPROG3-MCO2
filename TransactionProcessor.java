
public class TransactionProcessor {
  public boolean canProduceChange(Currency machineCurrency, int changeToBeReceived) {
    int machineOne = machineCurrency.getOne();
    int machineFive = machineCurrency.getFive();
    int machineTen = machineCurrency.getTen();
    int machineTwenty = machineCurrency.getTwenty();
    int machineFifty = machineCurrency.getFifty();
    int machineHundred = machineCurrency.getHundred();

    while (changeToBeReceived / 100 > 0 && machineHundred > 0) {
      changeToBeReceived -= 100;
      machineHundred--;
    }

    while (changeToBeReceived / 50 > 0 && machineFifty > 0) {
      changeToBeReceived -= 50;
      machineFifty--;
    }

    while (changeToBeReceived / 20 > 0 && machineTwenty > 0) {
      changeToBeReceived -= 20;
      machineTwenty--;
    }

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

  public int[] produceChange(Currency machineCurrency, int changeToBeProduced) {
    int change[] = new int[6];

    int machineOne = machineCurrency.getOne();
    int machineFive = machineCurrency.getFive();
    int machineTen = machineCurrency.getTen();
    int machineTwenty = machineCurrency.getTwenty();
    int machineFifty = machineCurrency.getFifty();
    int machineHundred = machineCurrency.getHundred();

    while (changeToBeProduced / 100 > 0 && machineHundred > 0) {
      changeToBeProduced -= 100;
      machineCurrency.deductHundred();
      change[5]++;
    }

    while (changeToBeProduced / 50 > 0 && machineFifty > 0) {
      changeToBeProduced -= 50;
      machineCurrency.deductFifty();
      change[4]++;
    }

    while (changeToBeProduced / 20 > 0 && machineTwenty > 0) {
      changeToBeProduced -= 20;
      machineCurrency.deductTwenty();
      change[3]++;
    }

    while (changeToBeProduced / 10 > 0 && machineTen > 0) {
      changeToBeProduced -= 10;
      machineCurrency.deductTen();
      change[2]++;
    }

    while (changeToBeProduced / 5 > 0 && machineFive > 0) {
      changeToBeProduced -= 5;
      machineCurrency.deductFive();
      change[1]++;
    }

    while (changeToBeProduced / 1 > 0 && machineOne > 0) {
      changeToBeProduced -= 1;
      machineCurrency.deductOne();
      change[0]++;
    }
    return change;
  }

  public void acceptAmount(Currency pendingBalance, Currency insertedBalance) {
    int[] balance;
    balance = new int[6];

    balance[0] = insertedBalance.getOne();
    balance[1] = insertedBalance.getFive();
    balance[2] = insertedBalance.getTen();
    balance[3] = insertedBalance.getTwenty();
    balance[4] = insertedBalance.getFifty();
    balance[5] = insertedBalance.getHundred();

    pendingBalance.replenishMoney(balance);
    insertedBalance.reset();
  }
}
