package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The MaintenanceFeatures class represents the graphical user interface for accessing maintenance features of the vending machine.
 * It provides buttons to access restock, change price, collect money, print transactions, and return to the main menu.
 */
public class MaintenanceFeatures extends JFrame {
  JButton btnRestock;
  JButton btnChangePrice;
  JButton btnCollectMoney;
  JButton btnPrintTransactions;
  JButton btnReturn;

  /**
   * Constructs a new MaintenanceFeatures frame with the specified GUI components and layout.
   */
  public MaintenanceFeatures() {
    this.setSize(300, 300);
    this.setLayout(new GridLayout(5, 1));
    this.setTitle("Maintenance Features");

    btnRestock = new JButton("Restock");
    btnChangePrice = new JButton("Change Price");
    btnCollectMoney = new JButton("Collect Money");
    btnPrintTransactions = new JButton("Print Transactions");
    btnReturn = new JButton("Return");
    this.add(btnRestock);
    this.add(btnChangePrice);
    this.add(btnCollectMoney);
    this.add(btnPrintTransactions);
    this.add(btnReturn);
    this.setLocationRelativeTo(null);
  }

  /**
   * Adds an ActionListener to the Restock button.
   *
   * @param listener The ActionListener to be added to the Restock button.
   */
  public void addBtnRestockListener(ActionListener listener) {
    btnRestock.addActionListener(listener);
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
   * Adds an ActionListener to the Collect Money button.
   *
   * @param listener The ActionListener to be added to the Collect Money button.
   */
  public void addBtnCollectMoneyListener(ActionListener listener) {
    btnCollectMoney.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the Print Transactions button.
   *
   * @param listener The ActionListener to be added to the Print Transactions button.
   */
  public void addBtnPrintTransactionsListener(ActionListener listener) {
    btnPrintTransactions.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the Return button.
   *
   * @param listener The ActionListener to be added to the Return button.
   */
  public void addBtnReturnListener(ActionListener listener) {
    btnReturn.addActionListener(listener);
  }
}
