package controller.handlers;

import javax.swing.JOptionPane;

import model.Factory;
import model.core.Item;
import com.view.ChangePrice;
import com.view.MaintenanceFeatures;


/**
 * The ChangePriceHandler class handles user interactions with the ChangePrice view and updates the model accordingly.
 */

public class ChangePriceHandler {
  private MaintenanceFeatures machFeatures;
  private ChangePrice changePrice;
  private Factory model;

   /**
     * Constructs a new ChangePriceHandler with the provided ChangePrice view, MaintenanceFeatures view, and Factory model.
     * @param changePrice The ChangePrice view for which this handler is responsible.
     * @param machFeatures The MaintenanceFeatures view from which this handler is called.
     * @param model The Factory model to be updated based on user interactions.
     */

  public ChangePriceHandler(ChangePrice changePrice, MaintenanceFeatures machFeatures, Factory model) {
    this.changePrice = changePrice;
    this.machFeatures = machFeatures;
    this.model = model;

    changePrice.addBtnChangePriceListener(e -> changePriceHanlder());
    changePrice.addBtnReturnListener(e -> returnHandler());
  }

  /**
     * Handles the "Change Price" button click event in the ChangePrice view.
     * If an item is selected, the method retrieves the new price from the view and updates the model accordingly.
     * It then updates the ChangePrice view with the latest item data from the model.
     * If no item is selected, it shows an error message.
     */

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

   /**
     * Handles the "Return" button click event in the ChangePrice view.
     * Disposes the ChangePrice view and makes the MaintenanceFeatures view visible.
     */
  public void returnHandler() {
    changePrice.dispose();
    machFeatures.setVisible(true);
  }

}
