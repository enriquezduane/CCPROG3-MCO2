package controller.handlers;

import model.*;
import model.core.*;
import view.*;

public class FeatureSelectorHandler {
  private FeatureSelector featureSelector;
  private VendingFeatures vendFeaturesNormal;
  private MaintenanceFeatures mainteFeaturesNormal;
  private Factory model;
  private Starter starter;

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

  private void handleReturn() {
    featureSelector.dispose();
    starter.setVisible(true);
  }

}
