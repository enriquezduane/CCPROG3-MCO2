package com.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The VendingFeatures class represents the graphical user interface for the vending machine features.
 * It allows the user to view items, insert coins, and buy items from the vending machine.
 */
public class VendingFeatures extends JFrame {
  JTable tblItemTable;
  JButton btnInsertOne;
  JButton btnInsertFive;
  JButton btnInsertTen;
  JButton btnReturnToFeature;
  JButton btnBuy;
  JPanel pnlInsert;
  JPanel pnlLeft;
  JPanel pnlRight;
  JPanel pnlInserted;
  JTextField txtOne;
  JTextField txtFive;
  JTextField txtTen;
  JTextField txtTotal;
  String[] tableHeading;
  String[][] tableData;
  DefaultTableModel tableModel;
  JScrollPane scrollTable;

  /**
   * Constructs a new VendingFeatures frame with the specified GUI components and layout.
   */
  public VendingFeatures() {
    this.setSize(900, 300);
    this.setTitle("Vending Features");
    this.setLayout(new BorderLayout());

    tableHeading = new String[] { "Name", "Quantity", "Price", "Calories" };
    tblItemTable = new JTable(tableData, tableHeading);
    tableModel = new DefaultTableModel(tableData, tableHeading);
    tblItemTable.setModel(tableModel);
    scrollTable = new JScrollPane(tblItemTable);

    txtOne = new JTextField();
    txtOne.setEditable(false);
    txtOne.setBorder(new TitledBorder("Inserted 1"));
    txtFive = new JTextField();
    txtFive.setEditable(false);
    txtFive.setBorder(new TitledBorder("Inserted 5"));
    txtTen = new JTextField();
    txtTen.setEditable(false);
    txtTen.setBorder(new TitledBorder("Inserted 10"));
    txtTotal = new JTextField();
    txtTotal.setEditable(false);
    txtTotal.setBorder(new TitledBorder("Total Inserted"));

    pnlInserted = new JPanel();
    pnlInserted.setLayout(new GridLayout(4, 1));
    pnlInserted.add(txtOne);
    pnlInserted.add(txtFive);
    pnlInserted.add(txtTen);
    pnlInserted.add(txtTotal);

    btnReturnToFeature = new JButton("Return");

    pnlLeft = new JPanel();
    pnlLeft.setLayout(new GridLayout(2, 1));
    pnlLeft.add(btnReturnToFeature);
    pnlLeft.add(pnlInserted);

    btnInsertOne = new JButton("1");
    btnInsertFive = new JButton("5");
    btnInsertTen = new JButton("10");

    pnlInsert = new JPanel();
    pnlInsert.setLayout(new GridLayout(3, 1));
    pnlInsert.setBorder(new TitledBorder("Coin Insertion"));
    pnlInsert.add(btnInsertOne);
    pnlInsert.add(btnInsertFive);
    pnlInsert.add(btnInsertTen);

    btnBuy = new JButton("Buy");

    pnlRight = new JPanel();
    pnlRight.setLayout(new GridLayout(2, 1));
    pnlRight.add(pnlInsert);
    pnlRight.add(btnBuy);

    pnlLeft.setPreferredSize(new Dimension(150, 300));
    pnlRight.setPreferredSize(new Dimension(150, 300));

    this.add(pnlLeft, BorderLayout.LINE_START);
    this.add(scrollTable, BorderLayout.CENTER);
    this.add(pnlRight, BorderLayout.LINE_END);
    this.setLocationRelativeTo(null);
  }

  /**
   * Adds an ActionListener to the Return button.
   *
   * @param listener The ActionListener to be added to the Return button.
   */
  public void addBtnReturnToFeature(ActionListener listener) {
    btnReturnToFeature.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the "Insert 1" button.
   *
   * @param listener The ActionListener to be added to the "Insert 1" button.
   */
  public void addBtnInsertOne(ActionListener listener) {
    btnInsertOne.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the "Insert 5" button.
   *
   * @param listener The ActionListener to be added to the "Insert 5" button.
   */
  public void addBtnInsertFive(ActionListener listener) {
    btnInsertFive.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the "Insert 10" button.
   *
   * @param listener The ActionListener to be added to the "Insert 10" button.
   */
  public void addBtnInsertTen(ActionListener listener) {
    btnInsertTen.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the Buy button.
   *
   * @param listener The ActionListener to be added to the Buy button.
   */
  public void addBtnBuy(ActionListener listener) {
    btnBuy.addActionListener(listener);
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
    DefaultTableModel tableModel = (DefaultTableModel) tblItemTable.getModel();
    tableModel.setRowCount(0);
    for (int i = 0; i < calories.length; i++) {
      tableModel.addRow(new Object[] { name[i], quantity[i], price[i], calories[i] });
    }
  }

  /**
   * Sets the text in the text fields representing the number of coins inserted (1, 5, 10, and total).
   *
   * @param one The number of 1-coin inserted.
   * @param five The number of 5-coins inserted.
   * @param ten The number of 10-coins inserted.
   * @param total The total amount of money inserted.
   */
  public void setTxtFields(int one, int five, int ten, int total) {
    txtOne.setText("" + one);
    txtFive.setText("" + five);
    txtTen.setText("" + ten);
    txtTotal.setText("" + total);
  }

  /**
   * Retrieves the name of the selected item in the table.
   *
   * @return The name of the selected item, or null if no item is selected.
   */
  public String getSelectedName() {
    String name;
    int selectedRow = tblItemTable.getSelectedRow();
    if (selectedRow == -1) {
      return null;
    }
    name = tblItemTable.getValueAt(selectedRow, 0).toString();
    return name;
  }
}
