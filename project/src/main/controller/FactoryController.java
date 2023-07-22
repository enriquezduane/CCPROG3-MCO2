package main.controller;
import main.view.*;
import main.model.*;

import javax.swing.*;

public class FactoryController {

  final private TestModel modelFactory;
  final private Starter viewStarter;
  final private SlotsPrompt viewSlotsPrompt;
  final private InsertItems viewInsertItems;

  public FactoryController(TestModel model, Starter v1, SlotsPrompt v2, InsertItems v3) {
    this.modelFactory = model;
    this.viewStarter = v1;
    this.viewSlotsPrompt = v2;
    this.viewInsertItems = v3;


    this.viewStarter.addNormalBtnListener(e -> handleNormalButtonAction());
    this.viewStarter.addSpecialBtnListener(e -> handleSpecialButtonAction());
    this.viewSlotsPrompt.addSlotPromptListener(e -> handleSlotPromptAction());
    this.viewInsertItems.addConfirmListener(e -> handleConfirmSpecialAction());

    this.viewStarter.setVisible(true);
  }

  private void handleNormalButtonAction(){
    viewStarter.dispose();
    viewSlotsPrompt.setVisible(true);
  }

  private void handleSpecialButtonAction(){
    // TODO
  }

  private void handleSlotPromptAction(){
    if (viewSlotsPrompt.getInputSlots() < 8){
      JOptionPane.showMessageDialog(null,"Please enter a valid number.");
    } else {
      viewInsertItems.setVisible(true);
      viewSlotsPrompt.dispose();
    }
  }

  private void handleConfirmSpecialAction(){
    String name = viewInsertItems.getInputName();
    int quantity = viewInsertItems.getInputQuantity();
    int price = viewInsertItems.getInputPrice();
    double calories = viewInsertItems.getInputCalories();

   viewInsertItems.addItemToTable(name,quantity,price,calories);
  }
}
