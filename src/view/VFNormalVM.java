package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VFNormalVM extends JFrame {
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

  public VFNormalVM() {
    this.setSize(600, 300); // Increase the size of the JFrame
    this.setLayout(new BorderLayout()); // Use BorderLayout for the main frame

    tableHeading = new String[] { "Name", "Quantity", "Price", "Calories" };
    tblItemTable = new JTable(tableData, tableHeading);
    tableModel = new DefaultTableModel(tableData, tableHeading);
    tblItemTable.setModel(tableModel);
    scrollTable = new JScrollPane(tblItemTable);

    txtOne = new JTextField();
    txtOne.setBorder(new TitledBorder("Inserted 1"));
    txtFive = new JTextField();
    txtFive.setBorder(new TitledBorder("Inserted 5"));
    txtTen = new JTextField();
    txtTen.setBorder(new TitledBorder("Inserted 10"));
    txtTotal = new JTextField();
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
  }
}
