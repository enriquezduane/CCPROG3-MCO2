package controller;

import model.*;
import view.*;

import javax.swing.*;

public class FactoryController {

  final private Factory modelFactory;
  final private Starter viewStarter;
  final private SlotsPrompt viewSlotsPrompt;
  final private InsertItems viewInsertItems;
  final private TypeSelector viewTypeSelector;
  final private FeatureSelector viewFeatureSelector;

  public FactoryController(Factory model, Starter v1, TypeSelector v2, SlotsPrompt v3, InsertItems v4,
      FeatureSelector v5) {
    this.modelFactory = model;
    this.viewStarter = v1;
    this.viewTypeSelector = v2;
    this.viewSlotsPrompt = v3;
    this.viewInsertItems = v4;
    this.viewFeatureSelector = v5;

    // VIEW STARTER ACTIONS
    this.viewStarter.addBtnCreateListener(e -> handleBtnCreateAction());
    this.viewStarter.addBtnTestListener(e -> handleBtnTestAction());

    // SLOTS PROMPT ACTIONS
    this.viewSlotsPrompt.addSlotPromptListener(e -> handleSlotPromptAction());

    // INSERT ITEM ACTIONS
    this.viewInsertItems.addAddListener(e -> handleAddAction());
    this.viewInsertItems.addConfirmListener(e -> handleConfirmListener());

    // TYPE SELECTOR ACTIONS
    this.viewTypeSelector.addBtnNormalListener(e -> handleBtnNormalAction());
    this.viewTypeSelector.addBtnSpecialListener(e -> handleBtnSpecialAction());

    // FEATURE SELECTOR ACTIONS
    this.viewFeatureSelector.addBtnVendingFTListener(e -> handleBtnVendingFTListener());
    this.viewFeatureSelector.addBtnMaintenanceFTListener(e -> handleBtnMaintenanceFTListener());

    this.viewStarter.setVisible(true);
  }

  private void handleBtnCreateAction() {
    viewStarter.dispose();
    viewTypeSelector.setVisible(true);
  }

  private void handleBtnTestAction() {
    if (modelFactory.getIsCreated() == false) {
      JOptionPane.showMessageDialog(null, "You haven't created a Vending Machine yet!");
    } else {
      viewStarter.dispose();
      viewFeatureSelector.setVisible(true);
    }
  }

  private void handleBtnNormalAction() {
    viewTypeSelector.dispose();
    viewSlotsPrompt.setVisible(true);
  }

  private void handleBtnSpecialAction() {
    System.out.println("Special");
  }

  private void handleSlotPromptAction() {
    int inputSlots = viewSlotsPrompt.getInputSlots();
    if (inputSlots < 1) {
      JOptionPane.showMessageDialog(null, "Please enter a valid number.");
    } else {
      viewSlotsPrompt.dispose();
      viewInsertItems.setSetSlots(inputSlots);
      viewInsertItems.setVisible(true);
    }
  }

  private void handleAddAction() {
    int numberOfItems = viewInsertItems.getNumberOfItems();
    String name = viewInsertItems.getInputName();
    int quantity = viewInsertItems.getInputQuantity();
    int price = viewInsertItems.getInputPrice();
    double calories = viewInsertItems.getInputCalories();

    viewInsertItems.setNumberOfItems(numberOfItems + 1);

    if (viewInsertItems.getNumberOfItems() >= 2) {
      viewInsertItems.setConfirmText("Confirm");
    }

    viewInsertItems.addItemToTable(name, quantity, price, calories);
  }

  private void handleConfirmListener() {
    int numberOfItems = viewInsertItems.getNumberOfItems();
    int numberOfSlots = viewInsertItems.getNumberOfSlots();
    int rowCount;
    String[] nameCol;
    int[] quantityCol, priceCol;
    double[] caloriesCol;
    JTable table = viewInsertItems.getTblItems();

    if (numberOfItems >= 2) {
      rowCount = table.getRowCount();
      nameCol = new String[rowCount];
      quantityCol = new int[rowCount];
      priceCol = new int[rowCount];
      caloriesCol = new double[rowCount];

      for (int i = 0; i < rowCount; i++) {
        nameCol[i] = String.valueOf(table.getValueAt(i, 0));
        quantityCol[i] = Integer.parseInt(String.valueOf(table.getValueAt(i, 1)));
        priceCol[i] = Integer.parseInt(String.valueOf(table.getValueAt(i, 2)));
        caloriesCol[i] = Double.parseDouble(String.valueOf(table.getValueAt(i, 3)));
      }

      modelFactory.addItemsInVendingMachine(nameCol, quantityCol, priceCol, caloriesCol);
      viewInsertItems.setNumberOfSlots(numberOfSlots + 1);
      viewInsertItems.setNumberOfItems(0);
      viewInsertItems.setConfirmText("...");
      viewInsertItems.clearTable();

      if (viewInsertItems.getSetSlots() == viewInsertItems.getNumberOfSlots()) {
        JOptionPane.showMessageDialog(null, "Vending Machine Successfully Created!");
        modelFactory.setIsCreated(true);
        viewInsertItems.dispose();
        viewStarter.setVisible(true);
      }
    } else {
      JOptionPane.showMessageDialog(null, "You need to have atleast 10 items!");
    }
  }

  private void handleBtnVendingFTListener() {
    System.out.println("Vending Features");
    modelFactory.debugItems();
  }

  private void handleBtnMaintenanceFTListener() {
    System.out.println("Maintenance Features");
  }

}
