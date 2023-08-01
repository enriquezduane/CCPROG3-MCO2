package com.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The InsertItems class represents the graphical user interface for inserting items into the vending machine.
 * It allows the user to enter details such as name, quantity, price, and calories for each item and displays them in a table.
 */
public class InsertItems extends JFrame {
  JTextField txtName;
  JTextField txtQuantity;
  JTextField txtPrice;
  JTextField txtCalories;
  JPanel pnlInput;
  JPanel pnlButtons;
  JButton btnAdd;
  JButton btnConfirm;
  JTable tblItems;
  DefaultTableModel tableModel;
  JScrollPane scrollTable;
  String[] tableHeading;
  String[][] tableData;
  int slots;
  int setSlots;
  int items;

  /**
   * Constructs a new InsertItems frame with the specified GUI components and layout.
   */
  public InsertItems() {
    this.setTitle("Insert Items");
    this.setSize(500, 250);
    this.setLayout(new GridLayout(1, 2));

    txtName = new JTextField();
    txtName.setBorder(new TitledBorder("Name"));

    txtQuantity = new JTextField();
    txtQuantity.setBorder(new TitledBorder("Quantity"));

    txtPrice = new JTextField();
    txtPrice.setBorder(new TitledBorder("Price"));

    txtCalories = new JTextField();
    txtCalories.setBorder(new TitledBorder("Calories"));

    btnAdd = new JButton("Add");
    btnConfirm = new JButton("...");

    pnlButtons = new JPanel();
    pnlButtons.setLayout(new GridLayout(1, 2));
    pnlButtons.add(btnAdd);
    pnlButtons.add(btnConfirm);

    pnlInput = new JPanel();
    pnlInput.setLayout(new GridLayout(5, 1));

    tableHeading = new String[] { "Name", "Quantity", "Price", "Calories" };
    tblItems = new JTable(tableData, tableHeading);
    tableModel = new DefaultTableModel(tableData, tableHeading);
    tblItems.setModel(tableModel);

    scrollTable = new JScrollPane(tblItems);

    pnlInput.add(txtName);
    pnlInput.add(txtQuantity);
    pnlInput.add(txtPrice);
    pnlInput.add(txtCalories);
    pnlInput.add(pnlButtons);

    this.add(pnlInput);
    this.add(scrollTable);
    this.setLocationRelativeTo(null);
  }

  /**
   * Adds an ActionListener to the Add button.
   *
   * @param listener The ActionListener to be added to the Add button.
   */
  public void addAddListener(ActionListener listener) {
    btnAdd.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the Confirm button.
   *
   * @param listener The ActionListener to be added to the Confirm button.
   */
  public void addConfirmListener(ActionListener listener) {
    btnConfirm.addActionListener(listener);
  }

  /**
   * Adds a new item to the table with the specified details (name, quantity, price, and calories).
   *
   * @param name The name of the item to be added.
   * @param quantity The quantity of the item to be added.
   * @param price The price of the item to be added.
   * @param calories The calorie content of the item to be added.
   */
  public void addItemToTable(String name, int quantity, int price, double calories) {
    DefaultTableModel tableModel = (DefaultTableModel) tblItems.getModel();
    tableModel.addRow(new Object[] { name, quantity, price, calories });
  }

  /**
   * Clears the table, removing all items from it.
   */
  public void clearTable() {
    DefaultTableModel tableModel = (DefaultTableModel) tblItems.getModel();
    tableModel.setRowCount(0);
  }

  /**
   * Clears the input fields for name, quantity, price, and calories.
   */
  public void clearInput() {
    txtName.setText("");
    txtPrice.setText("");
    txtQuantity.setText("");
    txtCalories.setText("");
  }

  /**
   * Sets the text of the Confirm button.
   *
   * @param text The text to be set on the Confirm button.
   */
  public void setConfirmText(String text) {
    btnConfirm.setText(text);
  }

  /**
   * Retrieves the name entered in the input field.
   *
   * @return The name entered by the user as a String.
   */
  public String getInputName() {
    return txtName.getText();
  }

  /**
   * Retrieves the quantity entered in the input field.
   *
   * @return The quantity entered by the user as an integer.
   */
  public int getInputQuantity() {
    return Integer.parseInt(txtQuantity.getText());
  }

  /**
   * Retrieves the price entered in the input field.
   *
   * @return The price entered by the user as an integer.
   */
  public int getInputPrice() {
    return Integer.parseInt(txtPrice.getText());
  }

  /**
   * Retrieves the calorie content entered in the input field.
   *
   * @return The calorie content entered by the user as a double.
   */
  public double getInputCalories() {
    return Double.parseDouble(txtCalories.getText());
  }

  /**
   * Retrieves the number of slots in the vending machine.
   *
   * @return The number of slots as an integer.
   */
  public int getNumberOfSlots() {
    return slots;
  }

  /**
   * Sets the number of slots in the vending machine.
   *
   * @param slots The number of slots to be set.
   */
  public void setNumberOfSlots(int slots) {
    this.slots = slots;
  }

  /**
   * Retrieves the total number of items in the vending machine.
   *
   * @return The total number of items as an integer.
   */
  public int getNumberOfItems() {
    return items;
  }

  /**
   * Sets the total number of items in the vending machine.
   *
   * @param items The total number of items to be set.
   */
  public void setNumberOfItems(int items) {
    this.items = items;
  }

  /**
   * Retrieves the number of slots set for the vending machine.
   *
   * @return The number of slots set as an integer.
   */
  public int getSetSlots() {
    return setSlots;
  }

  /**
   * Sets the number of slots for the vending machine.
   *
   * @param setSlots The number of slots to be set.
   */
  public void setSetSlots(int setSlots) {
    this.setSlots = setSlots;
  }

public JTable getTblItems() {
    return null;
}
}
