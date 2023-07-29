package controller.handlers;

import javax.swing.JOptionPane;

import model.*;
import model.core.*;
import view.*;

public class VFNormalHandler {
  VFNormal vendFeaturesNormal;
  Factory model;
  FeatureSelector features;

  public VFNormalHandler(VFNormal vendFeaturesNormal, Factory model, FeatureSelector features) {
    this.vendFeaturesNormal = vendFeaturesNormal;
    this.model = model;
    this.features = features;

    this.vendFeaturesNormal.addBtnReturnToFeature(e -> handleReturnToFeature());
    this.vendFeaturesNormal.addBtnInsertOne(e -> handleInsertOne());
    this.vendFeaturesNormal.addBtnInsertFive(e -> handleInsertFive());
    this.vendFeaturesNormal.addBtnInsertTen(e -> handleInsertTen());
    this.vendFeaturesNormal.addBtnBuy(e -> handleBuy());
  }

  private void handleReturnToFeature() {
    vendFeaturesNormal.dispose();
    features.setVisible(true);
  }

  private void handleInsertOne() {
    Currency currency = model.getInsertedCurrency();
    model.getInsertedCurrency().setOne(currency.getOne() + 1);
    vendFeaturesNormal.setTxtFields(currency.getOne(), currency.getFive(), currency.getTen(),
        currency.getTotalAmount());
  }

  private void handleInsertFive() {
    Currency currency = model.getInsertedCurrency();
    model.getInsertedCurrency().setFive(currency.getFive() + 1);
    vendFeaturesNormal.setTxtFields(currency.getOne(), currency.getFive(), currency.getTen(),
        currency.getTotalAmount());
  }

  private void handleInsertTen() {
    Currency currency = model.getInsertedCurrency();
    model.getInsertedCurrency().setTen(currency.getTen() + 1);
    vendFeaturesNormal.setTxtFields(currency.getOne(), currency.getFive(), currency.getTen(),
        currency.getTotalAmount());
  }

  private void handleBuy() {
    String selectedItem = vendFeaturesNormal.getSelectedName();
    if (selectedItem == null) {
      JOptionPane.showMessageDialog(null, "Select an item before you buy!");
    } else {
      model.buyItem(selectedItem);

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

      System.out.println(selectedItem);
    }
  }
}
