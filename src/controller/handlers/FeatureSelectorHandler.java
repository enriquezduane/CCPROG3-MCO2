package controller.handlers;

import model.*;
import model.core.*;
import view.*;

public class FeatureSelectorHandler {
  private FeatureSelector featureSelector;
  private VFNormal vendFeaturesNormal;
  private MFNormal mainteFeaturesNormal;
  private Factory model;

  public FeatureSelectorHandler(Factory model, FeatureSelector featureSelector, VFNormal vendFeaturesNormal,
      MFNormal mainteFeaturesNormal) {
    this.model = model;
    this.featureSelector = featureSelector;
    this.vendFeaturesNormal = vendFeaturesNormal;
    this.mainteFeaturesNormal = mainteFeaturesNormal;

    this.featureSelector.addBtnVendingFTListener(e -> handleBtnVendingFTListener());
    this.featureSelector.addBtnMaintenanceFTListener(e -> handleBtnMaintenanceFTListener());
  }

  // feature selector
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

  // feature selector
  private void handleBtnMaintenanceFTListener() {
    featureSelector.dispose();
    mainteFeaturesNormal.setVisible(true);
  }

}
