package view;

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

  public ChangePrice() {
    this.setSize(800, 400);
    this.setLayout(new GridLayout(1, 2));
    this.setTitle("Change Price");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

  public void addBtnChangePriceListener(ActionListener listener) {
    btnChangePrice.addActionListener(listener);
  }

  public void addBtnReturnListener(ActionListener listener) {
    btnReturn.addActionListener(listener);
  }

  public void setDatabase(String[] name, int[] quantity, int[] price, double[] calories) {
    DefaultTableModel tableModel = (DefaultTableModel) tblItems.getModel();
    tableModel.setRowCount(0);
    for (int i = 0; i < calories.length; i++) {
      tableModel.addRow(new Object[] { name[i], quantity[i], price[i], calories[i] });
    }
  }

  public String getSelectedName() {
    String name;
    int selectedRow = tblItems.getSelectedRow();
    if (selectedRow == -1) {
      return null;
    }
    name = tblItems.getValueAt(selectedRow, 0).toString();
    return name;
  }

  public void clearField() {
    txtPrice.setText("");
  }

  public String getNewPrice() {
    return txtPrice.getText();
  }

}
