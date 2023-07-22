package main;

import main.controller.FactoryController;
import main.view.*;
import main.model.*;

public class Main {
  public static void main(String[] args) {
    TestModel modelFactory = new TestModel();
    Starter viewStarter = new Starter();
    SlotsPrompt viewSlotsPrompt = new SlotsPrompt();

    new FactoryController(modelFactory,viewStarter,viewSlotsPrompt);

  }
}
