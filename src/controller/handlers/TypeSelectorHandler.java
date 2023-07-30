package controller.handlers;

import javax.swing.JOptionPane;

import model.Factory;
import view.*;

public class TypeSelectorHandler {
  TypeSelector typeSelector;
  SlotsPrompt slotsPrompt;
  Factory model;
  Starter starter;

  public TypeSelectorHandler(TypeSelector typeSelector, SlotsPrompt slotsPrompt, Factory model, Starter starter) {
    this.typeSelector = typeSelector;
    this.slotsPrompt = slotsPrompt;
    this.model = model;
    this.starter = starter;

    this.typeSelector.addBtnNormalListener(e -> handleBtnNormalAction());
    this.typeSelector.addBtnSpecialListener(e -> handleBtnSpecialAction());
  }

  private void handleBtnNormalAction() {
    typeSelector.dispose();
    slotsPrompt.setVisible(true);
  }

  private void handleBtnSpecialAction() {
    model.createSpecialVM();
    JOptionPane.showMessageDialog(null, "Special Vending Machine successfully created!");
    typeSelector.dispose();
    starter.setVisible(true);

  }
}
