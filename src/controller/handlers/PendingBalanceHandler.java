package controller.handlers;

import view.MFNormal;
import view.PendingBalance;

public class PendingBalanceHandler {
  private PendingBalance pendingBalance;
  private MFNormal machFeatures;

  public PendingBalanceHandler(PendingBalance pendingBalance, MFNormal machFeatures) {
    this.pendingBalance = pendingBalance;
    this.machFeatures = machFeatures;

    pendingBalance.addBtnConfirmListener(e -> confirmHandler());
  }

  public void confirmHandler() {
    pendingBalance.dispose();
    machFeatures.setVisible(true);
  }

}
