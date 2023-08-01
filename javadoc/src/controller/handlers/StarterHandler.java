package controller.handlers;

import javax.swing.JOptionPane;

import model.Factory;
import com.view.FeatureSelector;
import com.view.Starter;
import com.view.TypeSelector;

/**
 * The StarterHandler class handles user interactions with the Starter view and controls the flow of the application.
 */

public class StarterHandler {
  private Factory model;
  private Starter starter;
  private TypeSelector typeSelector;
  private FeatureSelector featureSelector;

  /**
     * Constructs a new StarterHandler with the provided components and model.
     * @param model The Factory model that will be updated based on user interactions.
     * @param starter The Starter view for which this handler is responsible.
     * @param typeSelector The TypeSelector view that will be shown after selecting the create option.
     * @param featureSelector The FeatureSelector view that will be shown after selecting the test option.
     */

  public StarterHandler(Factory model, Starter starter, TypeSelector typeSelector,
      FeatureSelector featureSelector) {
    this.model = model;
    this.starter = starter;
    this.typeSelector = typeSelector;
    this.featureSelector = featureSelector;

    this.starter.addBtnCreateListener(e -> handleBtnCreateAction());
    this.starter.addBtnTestListener(e -> handleBtnTestAction());
  }

  /**
     * Handles the "Create" button click event in the Starter view.
     * Disposes the Starter view and shows the TypeSelector view to select the machine type.
     * Clears the data in the Factory model to start fresh.
     */

  private void handleBtnCreateAction() {
    starter.dispose();
    model.clearData();
    typeSelector.setVisible(true);
  }
  
 /**
     * Handles the "Test" button click event in the Starter view.
     * If the Vending Machine is not yet created, displays an error message.
     * Otherwise, disposes the Starter view and shows the FeatureSelector view to select the feature to test.
     */

  private void handleBtnTestAction() {
    if (model.getIsCreated() == false) {
      JOptionPane.showMessageDialog(null, "You haven't created a Vending Machine yet!");
    } else {
      starter.dispose();
      featureSelector.setVisible(true);
    }
  }

}
