package controller;

import model.*;
import view.*;

import controller.handlers.*;

public class FactoryController {

  public FactoryController(Factory model, Starter v1, TypeSelector v2, SlotsPrompt v3, InsertItems v4,
      FeatureSelector v5, VendingFeatures v6, MaintenanceFeatures v7, Restock v8, ChangePrice v9, PendingBalance v10,
      PrintTransactions v11, Customizer v12, ReplenishMoney v13) {

    // model = FACTORY
    // v1 = STARTER
    // v2 = TYPE SELECTOR
    // v3 = SLOTS PROMPT
    // v4 = INSERT ITEMS
    // v5 = FEATURE SELECTOR
    // v6 = VENDING FEATURES
    // v7 = MAINTENANCE FEATURES
    // v8 = RESTOCK ITEMS
    // v9 = CHANGE PRICE OF AN ITEM
    // v10 = GET PENDING BALANCE
    // v11 = PRINT TRANSACTIONS
    // v12 = SPECIAL VENDING MACHINE CUSTOMIZER
    // v13 = REPLENISH MACHINE BALANCE

    new StarterHandler(model, v1, v2, v5);
    new SlotsPromptHandler(v4, v3, model, v1);
    new InsertItemsHandler(model, v1, v4);
    new TypeSelectorHandler(v2, v3, model, v1);
    new FeatureSelectorHandler(model, v5, v6, v7, v1);
    new VendingFeaturesHandler(v6, model, v5, v12);
    new MaintenanceFeaturesHandler(v7, v8, model, v9, v10, v11, v5, v13);
    new RestockHandler(v8, v7, model);
    new ChangePriceHandler(v9, v7, model);
    new PendingBalanceHandler(v10, v7, model);
    new PrintTransactionsHandler(v11, v7);
    new CustomizerHandler(v12, model, v6);
    new ReplenishMoneyHandler(v13, model, v7);

    v1.setVisible(true);
  }

}
