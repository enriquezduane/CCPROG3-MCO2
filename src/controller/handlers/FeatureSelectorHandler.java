package controller.handlers;

import view.*;

public class FeatureSelectorHandler {
  private FeatureSelector featureSelector;
  private VFNormalVM vendFeaturesNormalVM;

  public FeatureSelectorHandler(FeatureSelector featureSelector, VFNormalVM vendFeaturesNormalVM) {
    this.featureSelector = featureSelector;
    this.vendFeaturesNormalVM = vendFeaturesNormalVM;

    this.featureSelector.addBtnVendingFTListener(e -> handleBtnVendingFTListener());
    this.featureSelector.addBtnMaintenanceFTListener(e -> handleBtnMaintenanceFTListener());
  }

  // feature selector
  private void handleBtnVendingFTListener() {
    featureSelector.dispose();
    vendFeaturesNormalVM.setVisible(true);
  }

  // feature selector
  private void handleBtnMaintenanceFTListener() {
    System.out.println("Maintenance Features");
  }

}
