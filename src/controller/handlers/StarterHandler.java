package controller.handlers;

import javax.swing.JOptionPane;

import model.Factory;
import view.FeatureSelector;
import view.Starter;
import view.TypeSelector;

public class StarterHandler {
  private Factory model;
  private Starter starter;
  private TypeSelector typeSelector;
  private FeatureSelector featureSelector;

  public StarterHandler(Factory model, Starter starter, TypeSelector typeSelector,
      FeatureSelector featureSelector) {
    this.model = model;
    this.starter = starter;
    this.typeSelector = typeSelector;
    this.featureSelector = featureSelector;

    this.starter.addBtnCreateListener(e -> handleBtnCreateAction());
    this.starter.addBtnTestListener(e -> handleBtnTestAction());
  }

  private void handleBtnCreateAction() {
    starter.dispose();
    typeSelector.setVisible(true);
  }

  private void handleBtnTestAction() {
    if (model.getIsCreated() == false) {
      JOptionPane.showMessageDialog(null, "You haven't created a Vending Machine yet!");
    } else {
      starter.dispose();
      featureSelector.setVisible(true);
    }
  }

}
