package controller.handlers;

import javax.swing.JOptionPane;

import model.Factory;
import com.view.*;

/**
 * The TypeSelectorHandler class handles user interactions with the TypeSelector view and controls the flow of the application.
 */
public class TypeSelectorHandler {
  TypeSelector typeSelector;
  SlotsPrompt slotsPrompt;
  Factory model;
  Starter starter;

    /**
     * Constructs a new TypeSelectorHandler with the provided components and model.
     * @param typeSelector The TypeSelector view for which this handler is responsible.
     * @param slotsPrompt The SlotsPrompt view that will be shown after selecting the normal option.
     * @param model The Factory model that will be updated based on user interactions.
     * @param starter The Starter view that will be shown after creating a special Vending Machine.
     */

  public TypeSelectorHandler(TypeSelector typeSelector, SlotsPrompt slotsPrompt, Factory model, Starter starter) {
    this.typeSelector = typeSelector;
    this.slotsPrompt = slotsPrompt;
    this.model = model;
    this.starter = starter;

    this.typeSelector.addBtnNormalListener(e -> handleBtnNormalAction());
    this.typeSelector.addBtnSpecialListener(e -> handleBtnSpecialAction());
  }

   /**
     * Handles the "Normal Vending Machine" button click event in the TypeSelector view.
     * Disposes the TypeSelector view and shows the SlotsPrompt view to set the number of slots for the Vending Machine.
     */
  private void handleBtnNormalAction() {
    typeSelector.dispose();
    slotsPrompt.setVisible(true);
  }

   /**
     * Handles the "Special Vending Machine" button click event in the TypeSelector view.
     * Creates a special Vending Machine in the Factory model.
     * Displays a success message and shows the Starter view after successful creation.
     */

  private void handleBtnSpecialAction() {
    model.createSpecialVM();
    JOptionPane.showMessageDialog(null, "Special Vending Machine successfully created!");
    typeSelector.dispose();
    starter.setVisible(true);

  }
}
