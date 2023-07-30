package controller.handlers;

import javax.swing.JOptionPane;

import model.Factory;
import view.MFNormal;
import view.PendingBalance;

public class PendingBalanceHandler {
  private PendingBalance pendingBalance;
  private MFNormal machFeatures;
  private Factory model;

  public PendingBalanceHandler(PendingBalance pendingBalance, MFNormal machFeatures, Factory model) {
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
