package controller.handlers;

import javax.swing.*;

import model.*;
import view.*;

public class InsertItemsHandler {
  private Factory model;
  private Starter starter;
  private InsertItems insertItems;

  public InsertItemsHandler(Factory model, Starter starter, InsertItems insertItems) {
    this.model = model;
    this.starter = starter;
    this.insertItems = insertItems;

    this.insertItems.addAddListener(e -> handleAddAction());
    this.insertItems.addConfirmListener(e -> handleConfirmListener());
  }

  private void handleAddAction() {
    int numberOfItems = insertItems.getNumberOfItems();
    String name = insertItems.getInputName();
    int quantity = insertItems.getInputQuantity();
    int price = insertItems.getInputPrice();
    double calories = insertItems.getInputCalories();

    insertItems.setNumberOfItems(numberOfItems + 1);

    if (insertItems.getNumberOfItems() >= 2) {
      insertItems.setConfirmText("Confirm");
    }

    insertItems.addItemToTable(name, quantity, price, calories);
  }

  private void handleConfirmListener() {
    int numberOfItems = insertItems.getNumberOfItems();
    int numberOfSlots = insertItems.getNumberOfSlots();
    int rowCount;
    String[] nameCol;
    int[] quantityCol, priceCol;
    double[] caloriesCol;
    JTable table = insertItems.getTblItems();

    if (numberOfItems >= 2) {
      rowCount = table.getRowCount();
      nameCol = new String[rowCount];
      quantityCol = new int[rowCount];
      priceCol = new int[rowCount];
      caloriesCol = new double[rowCount];

      for (int i = 0; i < rowCount; i++) {
        nameCol[i] = String.valueOf(table.getValueAt(i, 0));
        quantityCol[i] = Integer.parseInt(String.valueOf(table.getValueAt(i, 1)));
        priceCol[i] = Integer.parseInt(String.valueOf(table.getValueAt(i, 2)));
        caloriesCol[i] = Double.parseDouble(String.valueOf(table.getValueAt(i, 3)));
      }

      model.addItemsInVendingMachine(nameCol, quantityCol, priceCol, caloriesCol);
      insertItems.setNumberOfSlots(numberOfSlots + 1);
      insertItems.setNumberOfItems(0);
      insertItems.setConfirmText("...");
      insertItems.clearTable();

      if (insertItems.getSetSlots() == insertItems.getNumberOfSlots()) {
        JOptionPane.showMessageDialog(null, "Vending Machine Successfully Created!");
        model.setIsCreated(true);
        insertItems.dispose();
        starter.setVisible(true);
      }
    } else {
      JOptionPane.showMessageDialog(null, "You need to have atleast 10 items!");
    }
  }

}
