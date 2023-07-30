package controller.handlers;

import view.*;

public class PrintTransactionsHandler {
  private PrintTransactions printTransactions;
  private MaintenanceFeatures machFeatures;

  public PrintTransactionsHandler(PrintTransactions printTransactions, MaintenanceFeatures machFeatures) {
    this.printTransactions = printTransactions;
    this.machFeatures = machFeatures;

    printTransactions.addBtnDone(e -> doneHandler());
  }

  public void doneHandler() {
    printTransactions.dispose();
    machFeatures.setVisible(true);
  }

}
