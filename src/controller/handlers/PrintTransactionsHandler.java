package controller.handlers;

import view.*;

public class PrintTransactionsHandler {
  private PrintTransactions printTransactions;
  private MFNormal machFeatures;

  public PrintTransactionsHandler(PrintTransactions printTransactions, MFNormal machFeatures) {
    this.printTransactions = printTransactions;
    this.machFeatures = machFeatures;

    printTransactions.addBtnDone(e -> doneHandler());
  }

  public void doneHandler() {
    printTransactions.dispose();
    machFeatures.setVisible(true);
  }

}
