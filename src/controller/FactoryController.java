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

  public FactoryController(Factory model, Starter v1, TypeSelector v2, SlotsPrompt v3, InsertItems v4) {
    this.modelFactory = model;
    this.viewStarter = v1;
    this.viewTypeSelector = v2;
    this.viewSlotsPrompt = v3;
    this.viewInsertItems = v4;

    this.viewStarter.addBtnCreateListener(e -> handleBtnCreateAction());
    this.viewStarter.addBtnTestListener(e -> handleBtnTestAction());

    this.viewSlotsPrompt.addSlotPromptListener(e -> handleSlotPromptAction());

    this.viewInsertItems.addConfirmListener(e -> handleConfirmAction());

    this.viewTypeSelector.addBtnNormalListener(e -> handleBtnNormalAction());
    this.viewTypeSelector.addBtnSpecialListener(e -> handleBtnSpecialAction());

    this.viewStarter.setVisible(true);
  }

  private void handleBtnCreateAction() {
    viewStarter.dispose();
    viewTypeSelector.setVisible(true);
  }

  private void handleBtnTestAction() {
    // TODO
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
    if (inputSlots < 8) {
      JOptionPane.showMessageDialog(null, "Please enter a valid number.");
    } else {
      viewSlotsPrompt.dispose();
      viewInsertItems.setVisible(true);
    }
  }

  private void handleConfirmAction() {
    String name = viewInsertItems.getInputName();
    int quantity = viewInsertItems.getInputQuantity();
    int price = viewInsertItems.getInputPrice();
    double calories = viewInsertItems.getInputCalories();

    viewInsertItems.addItemToTable(name, quantity, price, calories);
    viewInsertItems.clearInput();
  }

}
