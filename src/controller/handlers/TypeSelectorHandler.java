package controller.handlers;

import view.*;

public class TypeSelectorHandler {
  TypeSelector typeSelector;
  SlotsPrompt slotsPrompt;

  public TypeSelectorHandler(TypeSelector typeSelector, SlotsPrompt slotsPrompt) {
    this.typeSelector = typeSelector;
    this.slotsPrompt = slotsPrompt;
    this.typeSelector.addBtnNormalListener(e -> handleBtnNormalAction());
    this.typeSelector.addBtnSpecialListener(e -> handleBtnSpecialAction());
  }

  private void handleBtnNormalAction() {
    typeSelector.dispose();
    slotsPrompt.setVisible(true);
  }

  private void handleBtnSpecialAction() {
    System.out.println("Special");
  }
}
