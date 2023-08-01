package controller.handlers;

import com.view.*;

/**
 * The PrintTransactionsHandler class handles user interactions with the PrintTransactions view.
 */

public class PrintTransactionsHandler {
  private PrintTransactions printTransactions;
  private MaintenanceFeatures machFeatures;

  /**
     * Constructs a new PrintTransactionsHandler with the provided components.
     * @param printTransactions The PrintTransactions view for which this handler is responsible.
     * @param machFeatures The MaintenanceFeatures view from which this handler is called.
     */
  public PrintTransactionsHandler(PrintTransactions printTransactions, MaintenanceFeatures machFeatures) {
    this.printTransactions = printTransactions;
    this.machFeatures = machFeatures;

    printTransactions.addBtnDone(e -> doneHandler());
  }

  /**
     * Handles the "Done" button click event in the PrintTransactions view.
     * Disposes the PrintTransactions view and shows the MaintenanceFeatures view.
     */
  public void doneHandler() {
    printTransactions.dispose();
    machFeatures.setVisible(true);
  }

}
