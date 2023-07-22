package main.view;

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
  JButton btnConfirm;
  JTable tblItems;
  DefaultTableModel tableModel;
  JScrollPane scrollTable;
  String[] tableHeading;
  String[][] tableData;

  public InsertItems(){
    this.setSize(500,250);
    this.setLayout(new GridLayout(1,2));

    txtName = new JTextField();
    txtName.setBorder(new TitledBorder("Name"));

    txtQuantity = new JTextField();
    txtQuantity.setBorder(new TitledBorder("Quantity"));

    txtPrice = new JTextField();
    txtPrice.setBorder(new TitledBorder("Price"));

    txtCalories = new JTextField();
    txtCalories.setBorder(new TitledBorder("Calories"));

    btnConfirm = new JButton("Confirm");

    pnlInput = new JPanel();
    pnlInput.setLayout(new GridLayout(5,1));


    tableHeading = new String[] {"Name","Quantity","Price","Calories"};
    tblItems = new JTable(tableData,tableHeading);
    tableModel = new DefaultTableModel(tableData, tableHeading);
    tblItems.setModel(tableModel);

    scrollTable = new JScrollPane(tblItems);

    pnlInput.add(txtName);
    pnlInput.add(txtQuantity);
    pnlInput.add(txtPrice);
    pnlInput.add(txtCalories);
    pnlInput.add(btnConfirm);

    this.add(pnlInput);
    this.add(scrollTable);
  }

  public void addConfirmListener(ActionListener listener){
    btnConfirm.addActionListener(listener);
  }

  public void addItemToTable(String name, int quantity, int price, double calories) {
    DefaultTableModel tableModel = (DefaultTableModel) tblItems.getModel();
    tableModel.addRow(new Object[]{name, quantity, price, calories});
  }

  public String getInputName(){
    return txtName.getText();
  }

  public int getInputQuantity(){
    return Integer.parseInt(txtQuantity.getText());
  }

  public int getInputPrice(){
    return Integer.parseInt(txtPrice.getText());
  }

  public double getInputCalories(){
    return Double.parseDouble(txtCalories.getText());
  }
}
