package controller.handlers;

import view.ChangePrice;
import view.MFNormal;

public class ChangePriceHandler {
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
