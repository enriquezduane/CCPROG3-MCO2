package controller.handlers;

import javax.swing.JOptionPane;

import model.Factory;
import view.MaintenanceFeatures;
import view.PendingBalance;

public class PendingBalanceHandler {
  private PendingBalance pendingBalance;
  private MaintenanceFeatures machFeatures;
  private Factory model;

  public PendingBalanceHandler(PendingBalance pendingBalance, MaintenanceFeatures machFeatures, Factory model) {
    this.pendingBalance = pendingBalance;
    this.machFeatures = machFeatures;
    this.model = model;

    pendingBalance.addBtnConfirmListener(e -> confirmHandler());
  }

  public void confirmHandler() {
    model.transferBalance();
    JOptionPane.showMessageDialog(null, "Funds Transferred Successfully!");
    pendingBalance.dispose();
    machFeatures.setVisible(true);
  }

}
