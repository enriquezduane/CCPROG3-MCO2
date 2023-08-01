package controller.handlers;

import model.*;
import model.core.*;
import com.view.*;

/**
 * The FeatureSelectorHandler class handles user interactions with the FeatureSelector view and controls the flow of the application based on user choices.
 */

public class FeatureSelectorHandler {
  private FeatureSelector featureSelector;
  private VendingFeatures vendFeaturesNormal;
  private MaintenanceFeatures mainteFeaturesNormal;
  private Factory model;
  private Starter starter;

  /**
     * Constructs a new FeatureSelectorHandler with the provided components and model.
     * @param model The Factory model that will be updated based on user interactions.
     * @param featureSelector The FeatureSelector view that this handler is associated with.
     * @param vendFeaturesNormal The VendingFeatures view to be shown for normal vending operations.
     * @param mainteFeaturesNormal The MaintenanceFeatures view to be shown for maintenance operations.
     * @param starter The Starter view from which this handler is called.
     */
  public FeatureSelectorHandler(Factory model, FeatureSelector featureSelector, VendingFeatures vendFeaturesNormal,
      MaintenanceFeatures mainteFeaturesNormal, Starter starter) {
    this.model = model;
    this.featureSelector = featureSelector;
    this.vendFeaturesNormal = vendFeaturesNormal;
    this.mainteFeaturesNormal = mainteFeaturesNormal;
    this.starter = starter;

    this.featureSelector.addBtnVendingFTListener(e -> handleBtnVendingFTListener());
    this.featureSelector.addBtnMaintenanceFTListener(e -> handleBtnMaintenanceFTListener());
    this.featureSelector.addBtnReturn(e -> handleReturn());
  }

 /**
   * Handles the "Vending Features" button click event in the FeatureSelector view.
   * Disposes the FeatureSelector view and shows the VendingFeatures view with updated data from the model.
   */

  private void handleBtnVendingFTListener() {
    featureSelector.dispose();
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

    vendFeaturesNormal.setDatabase(itemNames, itemQuantities, itemPrices, itemCalories);
    vendFeaturesNormal.setVisible(true);
  }

 /**
   * Handles the "Maintenance Features" button click event in the FeatureSelector view.
   * Disposes the FeatureSelector view and shows the MaintenanceFeatures view.
   */

  private void handleBtnMaintenanceFTListener() {
    featureSelector.dispose();
    mainteFeaturesNormal.setVisible(true);
  }

 /**
   * Handles the "Return" button click event in the FeatureSelector view.
   * Disposes the FeatureSelector view and shows the Starter view.
   */
  
  private void handleReturn() {
    featureSelector.dispose();
    starter.setVisible(true);
  }

}
