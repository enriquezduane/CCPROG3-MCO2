package main;

import main.controller.FactoryController;
import main.view.*;
import main.model.*;

public class Main {
  public static void main(String[] args) {
    TestModel model = new TestModel();
    Starter v1 = new Starter();
    SlotsPrompt v2 = new SlotsPrompt();
    InsertItems v3 = new InsertItems();

    new FactoryController(model,v1,v2,v3);

  }
}
