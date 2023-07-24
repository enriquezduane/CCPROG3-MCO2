package controller.handlers;

import model.*;
import model.core.*;
import view.*;

public class FeatureSelectorHandler {
  private FeatureSelector featureSelector;
  private VFNormalVM vendFeaturesNormalVM;
  private Factory model;

  public FeatureSelectorHandler(Factory model, FeatureSelector featureSelector, VFNormalVM vendFeaturesNormalVM) {
    this.model = model;
    this.featureSelector = featureSelector;
    this.vendFeaturesNormalVM = vendFeaturesNormalVM;

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

    vendFeaturesNormalVM.setDatabase(itemNames, itemQuantities, itemPrices, itemCalories);
    vendFeaturesNormalVM.setVisible(true);
  }

  // feature selector
  private void handleBtnMaintenanceFTListener() {
    System.out.println("Maintenance Features");
  }

}
