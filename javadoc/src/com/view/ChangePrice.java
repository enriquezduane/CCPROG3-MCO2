package com.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 * The ChangePrice class represents the graphical user interface for changing the price of an item in the vending machine.
 * It allows the user to select an item from a table and enter a new price to update the item's price.
 */
public class ChangePrice extends JFrame {
  JPanel pnlButtons;
  JPanel pnlRight;
  JButton btnChangePrice;
  JButton btnReturn;
  JTextField txtPrice;
  JTable tblItems;
  JScrollPane scrollTable;
  String[] tableHeading;
  String[][] tableData;
  DefaultTableModel tableModel;

  /**
   * Constructs a new ChangePrice frame with the specified GUI components and layout.
   */
  public ChangePrice() {
    this.setSize(800, 400);
    this.setLayout(new GridLayout(1, 2));
    this.setTitle("Change Price");
    pnlRight = new JPanel();
    pnlRight.setLayout(new GridLayout(2, 1));

    pnlButtons = new JPanel();
    btnChangePrice = new JButton("Change Price");
    btnReturn = new JButton("Return");

    pnlButtons.add(btnReturn);
    pnlButtons.add(btnChangePrice);
    pnlButtons.setLayout(new GridLayout(2, 1));

    txtPrice = new JTextField();
    txtPrice.setBorder(new TitledBorder("Enter New Price"));

    pnlRight.add(pnlButtons);
    pnlRight.add(txtPrice);

    tableHeading = new String[] { "Name", "Quantity", "Price", "Calories" };
    tblItems = new JTable(tableData, tableHeading);
    tableModel = new DefaultTableModel(tableData, tableHeading);
    tblItems.setModel(tableModel);
    scrollTable = new JScrollPane(tblItems);

    this.add(scrollTable);
    this.add(pnlRight);
    this.setLocationRelativeTo(null);
  }

  /**
   * Adds an ActionListener to the Change Price button.
   *
   * @param listener The ActionListener to be added to the Change Price button.
   */
  public void addBtnChangePriceListener(ActionListener listener) {
    btnChangePrice.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the Return button.
   *
   * @param listener The ActionListener to be added to the Return button.
   */
  public void addBtnReturnListener(ActionListener listener) {
    btnReturn.addActionListener(listener);
  }

  /**
   * Sets the data of the table with the specified arrays of item details (name, quantity, price, and calories).
   *
   * @param name An array of item names.
   * @param quantity An array of item quantities.
   * @param price An array of item prices.
   * @param calories An array of item calorie contents.
   */
  public void setDatabase(String[] name, int[] quantity, int[] price, double[] calories) {
    DefaultTableModel tableModel = (DefaultTableModel) tblItems.getModel();
    tableModel.setRowCount(0);
    for (int i = 0; i < calories.length; i++) {
      tableModel.addRow(new Object[] { name[i], quantity[i], price[i], calories[i] });
    }
  }

  /**
   * Retrieves the name of the selected item in the table.
   *
   * @return The name of the selected item, or null if no item is selected.
   */
  public String getSelectedName() {
    String name;
    int selectedRow = tblItems.getSelectedRow();
    if (selectedRow == -1) {
      return null;
    }
    name = tblItems.getValueAt(selectedRow, 0).toString();
    return name;
  }

  /**
   * Retrieves the new price entered by the user.
   *
   * @return The new price entered by the user as a String.
   */
  public String getNewPrice() {
    return txtPrice.getText();
  }
}
