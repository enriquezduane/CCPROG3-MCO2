package controller;

import model.*;
import view.*;

import controller.handlers.*;

public class FactoryController {

  public FactoryController(Factory model, Starter v1, TypeSelector v2, SlotsPrompt v3, InsertItems v4,
      FeatureSelector v5, VFNormalVM v6) {

    // model = FACTORY
    // v1 = STARTER
    // v2 = TYPE SELECTOR
    // v3 = SLOTS PROMPT
    // v4 = INSERT ITEMS
    // v5 = FEATURE SELECTOR
    // v6 = VENDING FEATURES OF A NORMAL VENDING MACHINE

    new StarterHandler(model, v1, v2, v5);
    new SlotsPromptHandler(v4, v3, model, v1);
    new InsertItemsHandler(model, v1, v4);
    new TypeSelectorHandler(v2, v3);
    new FeatureSelectorHandler(model, v5, v6);
    new VFNormalVMHandler(v6, model, v5);

    v1.setVisible(true);
  }

}
