package controller.handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Factory;
import com.view.*;

/**
 * The SlotsPromptHandler class handles user interactions with the SlotsPrompt view and updates the model accordingly.
 */

public class SlotsPromptHandler {
  private InsertItems insertItems;
  private SlotsPrompt slotsPrompt;
  private Factory model;
  private Starter starter;

   /**
     * Constructs a new SlotsPromptHandler with the provided components and model.
     * @param insertItems The InsertItems view for which this handler is responsible.
     * @param slotsPrompt The SlotsPrompt view from which this handler is called.
     * @param model The Factory model that will be updated based on user interactions.
     * @param starter The Starter view that will be shown after setting the number of slots.
     */

  public SlotsPromptHandler(InsertItems insertItems, SlotsPrompt slotsPrompt, Factory model, Starter starter) {
    this.insertItems = insertItems;
    this.slotsPrompt = slotsPrompt;
    this.model = model;
    this.starter = starter;

    this.slotsPrompt.addSlotPromptListener(e -> handleSlotPromptAction());
    this.slotsPrompt.addDebugListener(e -> handleDebugAction());
  }

   /**
     * Handles the "OK" button click event in the SlotsPrompt view.
     * Sets the number of slots in the InsertItems view and shows the InsertItems view.
     * Displays an error message if the input slots value is less than 1.
     */

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

  /**
     * Handles the "Debug" button click event in the SlotsPrompt view.
     * Reads preset values from a file and sets up the Vending Machine accordingly.
     * Displays a success message and shows the Starter view after successful setup.
     * Displays an error message if the preset file is not found.
     */
    
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
