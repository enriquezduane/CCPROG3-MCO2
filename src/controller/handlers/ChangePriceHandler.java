package controller.handlers;

import view.ChangePrice;
import view.MFNormal;
import view.Restock;

public class ChangePriceHandler {
  private Restock restock;
  private MFNormal machFeatures;
  private ChangePrice changePrice;

  public ChangePriceHandler(ChangePrice changePrice, MFNormal machFeatures) {
    this.changePrice = changePrice;
    this.machFeatures = machFeatures;

    changePrice.addBtnChangePriceListener(e -> changePriceHanlder());
    changePrice.addBtnReturnListener(e -> returnHandler());
  }

  public void changePriceHanlder() {
    System.out.println("change price");
  }

  public void returnHandler() {
    changePrice.dispose();
    machFeatures.setVisible(true);
  }

}
