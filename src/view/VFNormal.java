package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class VFNormal extends JFrame {
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

  public VFNormal() {
    this.setSize(600, 300); // Increase the size of the JFrame
    this.setTitle("Vending Features (Normal VM)");
    this.setLayout(new BorderLayout()); // Use BorderLayout for the main frame

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

  public void addBtnReturnToFeature(ActionListener listener) {
    btnReturnToFeature.addActionListener(listener);
  }

  public void addBtnInsertOne(ActionListener listener) {
    btnInsertOne.addActionListener(listener);
  }

  public void addBtnInsertFive(ActionListener listener) {
    btnInsertFive.addActionListener(listener);
  }

  public void addBtnInsertTen(ActionListener listener) {
    btnInsertTen.addActionListener(listener);
  }

  public void addBtnBuy(ActionListener listener) {
    btnBuy.addActionListener(listener);
  }

  public void setDatabase(String[] name, int[] quantity, int[] price, double[] calories) {
    DefaultTableModel tableModel = (DefaultTableModel) tblItemTable.getModel();
    tableModel.setRowCount(0);
    for (int i = 0; i < calories.length; i++) {
      tableModel.addRow(new Object[] { name[i], quantity[i], price[i], calories[i] });
    }
  }

  public void setTxtFields(int one, int five, int ten, int total) {
    txtOne.setText("" + one);
    txtFive.setText("" + five);
    txtTen.setText("" + ten);
    txtTotal.setText("" + total);
  }

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
