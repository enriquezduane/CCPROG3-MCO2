package controller.handlers;

import model.Factory;
import model.core.Item;
import view.ChangePrice;
import view.MFNormal;

public class ChangePriceHandler {
  private MFNormal machFeatures;
  private ChangePrice changePrice;
  private Factory model;

  public ChangePriceHandler(ChangePrice changePrice, MFNormal machFeatures, Factory model) {
    this.changePrice = changePrice;
    this.machFeatures = machFeatures;
    this.model = model;

    changePrice.addBtnChangePriceListener(e -> changePriceHanlder());
    changePrice.addBtnReturnListener(e -> returnHandler());
  }

  public void changePriceHanlder() {
    String itemName = changePrice.getSelectedName();
    int newPrice = Integer.parseInt(changePrice.getNewPrice());
    model.changePrice(itemName, newPrice);
    Item[] itemsList = model.getAllItems();
    String[] itemNames = new String[itemsList.length];
    int[] itemQuantities = new int[itemsList.length];
    int[] itemPrices = new int[itemsList.length];
    double[] itemCalories = new double[itemsList.length];

    for (int i = 0; i < itemsList.length; i++) {
      itemNames[i] = itemsList[i].getName();
      itemQuantities[i] = itemsList[i].getQuantity();
      itemPrices[i] = itemsList[i].getPrice();
      itemCalories[i] = itemsList[i].getCalories();
    }

    changePrice.setDatabase(itemNames, itemQuantities, itemPrices, itemCalories);
  }

  public void returnHandler() {
    changePrice.dispose();
    machFeatures.setVisible(true);
  }

}
