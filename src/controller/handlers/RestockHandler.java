package controller.handlers;

import javax.swing.JOptionPane;

import model.Factory;
import model.core.Item;
import view.*;

public class RestockHandler {
  private Restock restock;
  private MaintenanceFeatures machFeatures;
  private Factory model;

  public RestockHandler(Restock restock, MaintenanceFeatures machFeatures, Factory model) {
    this.restock = restock;
    this.machFeatures = machFeatures;
    this.model = model;

    restock.addBtnRestockListener(e -> restockHandler());
    restock.addBtnReturnListener(e -> returnHandler());
  }

  public void restockHandler() {

    String name = restock.getSelectedName();
    int restockAmount = Integer.parseInt(restock.getRestockAmount());

    if (name == null) {
      JOptionPane.showMessageDialog(null, "Select an item before you restock!");
    } else {
      model.restockItem(name, restockAmount);

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

      restock.setDatabase(itemNames, itemQuantities, itemPrices, itemCalories);
    }

  }

  public void returnHandler() {
    restock.dispose();
    machFeatures.setVisible(true);
  }

}
