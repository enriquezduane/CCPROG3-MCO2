package controller.handlers;

import model.Factory;
import model.core.Item;
import view.*;

public class MFNormalHandler {
  private MFNormal mainteNormalFeatures;
  private Restock restockNormal;
  private Factory model;
  private ChangePrice changePrice;
  private PendingBalance pendingBalance;
  private PrintTransactions printTransactions;
  private FeatureSelector featureSelector;

  public MFNormalHandler(MFNormal mainteNormalFeatures, Restock restockNormal, Factory model, ChangePrice changePrice,
      PendingBalance pendingBalance, PrintTransactions printTransactions, FeatureSelector featureSelector) {
    this.mainteNormalFeatures = mainteNormalFeatures;
    this.restockNormal = restockNormal;
    this.model = model;
    this.changePrice = changePrice;
    this.pendingBalance = pendingBalance;
    this.printTransactions = printTransactions;
    this.featureSelector = featureSelector;

    this.mainteNormalFeatures.addBtnChangePriceListener(e -> handleChangePrice());
    this.mainteNormalFeatures.addBtnRestockListener(e -> handleRestock());
    this.mainteNormalFeatures.addBtnCollectMoneyListener(e -> handleCollectMoney());
    this.mainteNormalFeatures.addBtnPrintTransactionsListener(e -> handlePrintTransactions());
    this.mainteNormalFeatures.addBtnReturnListener(e -> handleReturn());
  }

  public void handleChangePrice() {
    mainteNormalFeatures.dispose();

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

    changePrice.setVisible(true);
  }

  public void handleRestock() {
    System.out.println("restock");
    this.mainteNormalFeatures.dispose();

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

    restockNormal.setDatabase(itemNames, itemQuantities, itemPrices, itemCalories);
    restockNormal.setVisible(true);
  }

  public void handleCollectMoney() {
    mainteNormalFeatures.dispose();
    pendingBalance.setVisible(true);
  }

  public void handlePrintTransactions() {
    mainteNormalFeatures.dispose();
    printTransactions.setVisible(true);
  }

  public void handleReturn() {
    mainteNormalFeatures.dispose();
    featureSelector.setVisible(true);
  }

}