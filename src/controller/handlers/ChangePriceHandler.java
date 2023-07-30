package controller.handlers;

import javax.swing.JOptionPane;

import model.Factory;
import model.core.Item;
import view.ChangePrice;
import view.MaintenanceFeatures;

public class ChangePriceHandler {
  private MaintenanceFeatures machFeatures;
  private ChangePrice changePrice;
  private Factory model;

  public ChangePriceHandler(ChangePrice changePrice, MaintenanceFeatures machFeatures, Factory model) {
    this.changePrice = changePrice;
    this.machFeatures = machFeatures;
    this.model = model;

    changePrice.addBtnChangePriceListener(e -> changePriceHanlder());
    changePrice.addBtnReturnListener(e -> returnHandler());
  }

  public void changePriceHanlder() {
    String itemName = changePrice.getSelectedName();

    if (itemName == null) {
      JOptionPane.showMessageDialog(null, "Select an item before you change price!");
    } else {
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

  }

  public void returnHandler() {
    changePrice.dispose();
    machFeatures.setVisible(true);
  }

}
