package controller.handlers;

import javax.swing.JOptionPane;

import view.*;

public class SlotsPromptHandler {
  private InsertItems insertItems;
  private SlotsPrompt slotsPrompt;

  public SlotsPromptHandler(InsertItems insertItems, SlotsPrompt slotsPrompt) {
    this.insertItems = insertItems;
    this.slotsPrompt = slotsPrompt;

    this.slotsPrompt.addSlotPromptListener(e -> handleSlotPromptAction());
  }

  private void handleSlotPromptAction() {
    int inputSlots = slotsPrompt.getInputSlots();
    if (inputSlots < 1) {
      JOptionPane.showMessageDialog(null, "Please enter a valid number.");
    } else {
      slotsPrompt.dispose();
      insertItems.setSetSlots(inputSlots);
      insertItems.setVisible(true);
    }
  }
}
