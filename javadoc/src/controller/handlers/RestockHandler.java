package controller.handlers;

import javax.swing.JOptionPane;

import model.Factory;
import model.core.Item;
import com.view.*;

/**
 * The RestockHandler class handles user interactions with the Restock view and updates the model accordingly.
 */

public class RestockHandler {
  private Restock restock;
  private MaintenanceFeatures machFeatures;
  private Factory model;

  /**
     * Constructs a new RestockHandler with the provided components and model.
     * @param restock The Restock view for which this handler is responsible.
     * @param machFeatures The MaintenanceFeatures view from which this handler is called.
     * @param model The Factory model that will be updated based on user interactions.
     */

  public RestockHandler(Restock restock, MaintenanceFeatures machFeatures, Factory model) {
    this.restock = restock;
    this.machFeatures = machFeatures;
    this.model = model;

    restock.addBtnRestockListener(e -> restockHandler());
    restock.addBtnReturnListener(e -> returnHandler());
  }

  /**
     * Handles the "Restock" button click event in the Restock view.
     * Restocks the selected item with the specified quantity in the Factory model.
     * Updates the Restock view with the latest data from the model.
     */

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

   /**
     * Handles the "Return" button click event in the Restock view.
     * Disposes the Restock view and shows the MaintenanceFeatures view.
     */
  public void returnHandler() {
    restock.dispose();
    machFeatures.setVisible(true);
  }

}
