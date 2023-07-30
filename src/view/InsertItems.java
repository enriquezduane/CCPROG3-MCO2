package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

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

  public InsertItems() {
    this.setTitle("Insert Items");
    this.setSize(500, 250);
    this.setLayout(new GridLayout(1, 2));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

  public void addAddListener(ActionListener listener) {
    btnAdd.addActionListener(listener);
  }

  public void addConfirmListener(ActionListener listener) {
    btnConfirm.addActionListener(listener);
  }

  public void addItemToTable(String name, int quantity, int price, double calories) {
    DefaultTableModel tableModel = (DefaultTableModel) tblItems.getModel();
    tableModel.addRow(new Object[] { name, quantity, price, calories });
  }

  public void clearTable() {
    DefaultTableModel tableModel = (DefaultTableModel) tblItems.getModel();
    tableModel.setRowCount(0);
  }

  public void clearInput() {
    txtName.setText("");
    txtPrice.setText("");
    txtQuantity.setText("");
    txtCalories.setText("");
  }

  public void setConfirmText(String text) {
    btnConfirm.setText(text);
  }

  public JTable getTblItems() {
    return tblItems;
  }

  public String getInputName() {
    return txtName.getText();
  }

  public int getInputQuantity() {
    return Integer.parseInt(txtQuantity.getText());
  }

  public int getInputPrice() {
    return Integer.parseInt(txtPrice.getText());
  }

  public double getInputCalories() {
    return Double.parseDouble(txtCalories.getText());
  }

  public int getNumberOfSlots() {
    return slots;
  }

  public void setNumberOfSlots(int slots) {
    this.slots = slots;
  }

  public int getNumberOfItems() {
    return items;
  }

  public void setNumberOfItems(int items) {
    this.items = items;
  }

  public int getSetSlots() {
    return setSlots;
  }

  public void setSetSlots(int setSlots) {
    this.setSlots = setSlots;
  }
}
