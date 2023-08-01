package controller.handlers;

import javax.swing.JOptionPane;

import model.Factory;
import com.view.MaintenanceFeatures;
import com.view.PendingBalance;

/**
 * The PendingBalanceHandler class handles user interactions with the PendingBalance view and updates the model accordingly.
 */

public class PendingBalanceHandler {
  private PendingBalance pendingBalance;
  private MaintenanceFeatures machFeatures;
  private Factory model;

   /**
     * Constructs a new PendingBalanceHandler with the provided components and model.
     * @param pendingBalance The PendingBalance view for which this handler is responsible.
     * @param machFeatures The MaintenanceFeatures view from which this handler is called.
     * @param model The Factory model that will be updated based on user interactions.
     */
  public PendingBalanceHandler(PendingBalance pendingBalance, MaintenanceFeatures machFeatures, Factory model) {
    this.pendingBalance = pendingBalance;
    this.machFeatures = machFeatures;
    this.model = model;

    pendingBalance.addBtnConfirmListener(e -> confirmHandler());
  }
 /**
     * Handles the "Confirm" button click event in the PendingBalance view.
     * Transfers the pending balance to the machine balance in the Factory model.
     * Displays a success message and shows the MaintenanceFeatures view when the transfer is successful.
     */
  public void confirmHandler() {
    model.transferBalance();
    JOptionPane.showMessageDialog(null, "Funds Transferred Successfully!");
    pendingBalance.dispose();
    machFeatures.setVisible(true);
  }

}
