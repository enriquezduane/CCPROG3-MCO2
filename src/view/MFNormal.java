package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MFNormal extends JFrame {
  JButton btnRestock;
  JButton btnChangePrice;
  JButton btnCollectMoney;
  JButton btnPrintTransactions;
  JButton btnReturn;

  public MFNormal() {
    this.setSize(300, 300);
    this.setLayout(new GridLayout(5, 1));
    this.setTitle("Maintenance Features Normal");

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

  public void addBtnRestockListener(ActionListener listener) {
    btnRestock.addActionListener(listener);
  }

  public void addBtnChangePriceListener(ActionListener listener) {
    btnChangePrice.addActionListener(listener);
  }

  public void addBtnCollectMoneyListener(ActionListener listener) {
    btnCollectMoney.addActionListener(listener);
  }

  public void addBtnPrintTransactionsListener(ActionListener listener) {
    btnPrintTransactions.addActionListener(listener);
  }

  public void addBtnReturnListener(ActionListener listener) {
    btnReturn.addActionListener(listener);
  }
}