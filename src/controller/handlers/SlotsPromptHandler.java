package controller.handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Factory;
import view.*;

public class SlotsPromptHandler {
  private InsertItems insertItems;
  private SlotsPrompt slotsPrompt;
  private Factory model;
  private Starter starter;

  public SlotsPromptHandler(InsertItems insertItems, SlotsPrompt slotsPrompt, Factory model, Starter starter) {
    this.insertItems = insertItems;
    this.slotsPrompt = slotsPrompt;
    this.model = model;
    this.starter = starter;

    this.slotsPrompt.addSlotPromptListener(e -> handleSlotPromptAction());
    this.slotsPrompt.addDebugListener(e -> handleDebugAction());
  }

  private void handleSlotPromptAction() {
    int inputSlots = slotsPrompt.getInputSlots();
    if (inputSlots < 8) {
      JOptionPane.showMessageDialog(null, "Please enter a valid number.");
    } else {
      slotsPrompt.dispose();
      insertItems.setSetSlots(inputSlots);
      insertItems.setVisible(true);
    }
  }

  private void handleDebugAction() {
    try {
      File presetValues = new File("src/controller/preset/preset.txt");
      Scanner debug = new Scanner(presetValues);

      String[] name = new String[20];
      int[] quantity = new int[20];
      int[] price = new int[20];
      double[] calories = new double[20];

      for (int i = 0; i < 20; i++) {
        name[i] = debug.nextLine();
        quantity[i] = Integer.parseInt(debug.nextLine());
        price[i] = Integer.parseInt(debug.nextLine());
        calories[i] = Double.parseDouble(debug.nextLine());
      }
      debug.close();
      JOptionPane.showMessageDialog(null, "Vending Machine Successfully Created!");
      model.addItemsInVendingMachine(name, quantity, price, calories);
      model.setIsCreated(true);
      slotsPrompt.dispose();
      starter.setVisible(true);
    } catch (FileNotFoundException e) {
      System.out.println("THE FILE IS MISSING BRO");
    }
  }

}
