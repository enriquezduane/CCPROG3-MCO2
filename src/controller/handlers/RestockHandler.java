package controller.handlers;

import view.MFNormal;
import view.Restock;

public class RestockHandler {
  private Restock restock;
  private MFNormal machFeatures;

  public RestockHandler(Restock restock, MFNormal machFeatures) {
    this.restock = restock;
    this.machFeatures = machFeatures;

    restock.addBtnRestockListener(e -> restockHandler());
    restock.addBtnReturnListener(e -> returnHandler());
  }

  public void restockHandler() {
    System.out.println("restock");
  }

  public void returnHandler() {
    restock.dispose();
    machFeatures.setVisible(true);
  }

}
