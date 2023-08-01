package controller;

import model.*;
import com.view.*;

import controller.handlers.*;

public class FactoryController {

/**
 * The FactoryController class acts as the main controller for the vending machine application. It facilitates
 * communication between the model (Factory) and various view components (Starter, TypeSelector, SlotsPrompt, 
 * InsertItems, FeatureSelector, VendingFeatures, MaintenanceFeatures, Restock, ChangePrice, PendingBalance, 
 * PrintTransactions) by creating and managing corresponding handler instances.
 */
  public FactoryController(Factory model, Starter v1, TypeSelector v2, SlotsPrompt v3, InsertItems v4,
      FeatureSelector v5, VendingFeatures v6, MaintenanceFeatures v7, Restock v8, ChangePrice v9, PendingBalance v10,
      PrintTransactions v11) {

/**
   * Constructs a new FactoryController object and initializes the necessary handlers to manage the interactions
   * between the model and view components of the vending machine application.
   *
   * @param model The Factory object representing the vending machine.
   * @param v1 The Starter view component to start the vending machine application.
   * @param v2 The TypeSelector view component for selecting the item type to purchase.
   * @param v3 The SlotsPrompt view component for prompting the user to select a slot.
   * @param v4 The InsertItems view component for inserting items into the vending machine.
   * @param v5 The FeatureSelector view component for selecting additional features.
   * @param v6 The VendingFeatures view component representing the features of a normal vending machine.
   * @param v7 The MaintenanceFeatures view component representing the maintenance features of a vending machine.
   * @param v8 The Restock view component for restocking items in the vending machine.
   * @param v9 The ChangePrice view component for changing the price of an item in the vending machine.
   * @param v10 The PendingBalance view component for getting the pending balance of the vending machine.
   * @param v11 The PrintTransactions view component for printing the transaction history of the vending machine.
   
   */
    new StarterHandler(model, v1, v2, v5);
    new SlotsPromptHandler(v4, v3, model, v1);
    new InsertItemsHandler(model, v1, v4);
    new TypeSelectorHandler(v2, v3, model, v1);
    new FeatureSelectorHandler(model, v5, v6, v7, v1);
    new VendingFeaturesHandler(v6, model, v5);
    new MaintenanceFeaturesHandler(v7, v8, model, v9, v10, v11, v5);
    new RestockHandler(v8, v7, model);
    new ChangePriceHandler(v9, v7, model);
    new PendingBalanceHandler(v10, v7, model);
    new PrintTransactionsHandler(v11, v7);

    // Make the Starter view component visible to start the vending machine application.
    v1.setVisible(true);
  }

}
