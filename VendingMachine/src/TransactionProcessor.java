
public class TransactionProcessor {
  public boolean canProduceChange(Currency insertedCurrency, Currency machineCurrency, int itemPrice) {
    // assumes machine already accepted the inserted Currency
    int insertedTotalAmount = insertedCurrency.getTotalAmount() - itemPrice;
    int machineOne = machineCurrency.getOne() + insertedCurrency.getOne();
    int machineFive = machineCurrency.getFive() + insertedCurrency.getFive();
    int machineTen = machineCurrency.getTen() + insertedCurrency.getTen();
    int machineTwenty = machineCurrency.getTwenty() + insertedCurrency.getTwenty();
    int machineFifty = machineCurrency.getFifty() + insertedCurrency.getFifty();
    int machineHundred = machineCurrency.getHundred() + insertedCurrency.getHundred();
    int machineTotalAmount = machineOne + (machineFive * 5) + (machineTen * 10) + (machineTwenty * 20)
        + (machineFifty * 50) + (machineHundred * 100);

    int changeProduced = 1;

    if (machineTotalAmount < insertedTotalAmount) {
      return false;
    }

    while (changeProduced > 0) {
      changeProduced = 0;

      while (insertedTotalAmount / 100 > 0 && machineHundred > 0) {
        insertedTotalAmount -= 100;
        changeProduced++;
        machineHundred--;
      }

      while (insertedTotalAmount / 50 > 0 && machineFifty > 0) {
        insertedTotalAmount -= 50;
        changeProduced++;
        machineFifty--;
      }

      while (insertedTotalAmount / 20 > 0 && machineTwenty > 0) {
        insertedTotalAmount -= 20;
        changeProduced++;
        machineTwenty--;
      }

      while (insertedTotalAmount / 10 > 0 && machineTen > 0) {
        insertedTotalAmount -= 10;
        changeProduced++;
        machineTen--;
      }

      while (insertedTotalAmount / 5 > 0 && machineFive > 0) {
        insertedTotalAmount -= 5;
        changeProduced++;
        machineFive--;
      }

      while (insertedTotalAmount / 1 > 0 && machineOne > 0) {
        insertedTotalAmount -= 1;
        changeProduced++;
        machineOne--;
      }
    }

    if (insertedTotalAmount > 0) {
      return false;
    }

    return true;

  }

  public int[] produceChange(Currency insertedCurrency, Currency machineCurrency, int itemPrice) {
    int change[] = new int[6];
    int insertedTotalAmount;

    int machineOne = machineCurrency.getOne();
    int machineFive = machineCurrency.getFive();
    int machineTen = machineCurrency.getTen();
    int machineTwenty = machineCurrency.getTwenty();
    int machineFifty = machineCurrency.getFifty();
    int machineHundred = machineCurrency.getHundred();

    insertedTotalAmount = insertedCurrency.getTotalAmount() - itemPrice;

    while (insertedTotalAmount / 100 > 0 && machineHundred > 0) {
      insertedTotalAmount -= 100;
      machineCurrency.deductHundred();
      change[5]++;
    }

    while (insertedTotalAmount / 50 > 0 && machineFifty > 0) {
      insertedTotalAmount -= 50;
      machineCurrency.deductFifty();
      change[4]++;
    }

    while (insertedTotalAmount / 20 > 0 && machineTwenty > 0) {
      insertedTotalAmount -= 20;
      machineCurrency.deductTwenty();
      change[3]++;
    }

    while (insertedTotalAmount / 10 > 0 && machineTen > 0) {
      insertedTotalAmount -= 10;
      machineCurrency.deductTen();
      change[2]++;
    }

    while (insertedTotalAmount / 5 > 0 && machineFive > 0) {
      insertedTotalAmount -= 5;
      machineCurrency.deductFive();
      change[1]++;
    }

    while (insertedTotalAmount / 1 > 0 && machineOne > 0) {
      insertedTotalAmount -= 1;
      machineCurrency.deductOne();
      change[0]++;
    }
    return change;
  }

  public void acceptAmount(Currency machineBalance, Currency insertedBalance, int itemPrice) {

  }
}
