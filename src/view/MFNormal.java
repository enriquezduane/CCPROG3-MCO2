package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MFNormal extends JFrame {
  JButton btnRestock;
  JButton btnChangePrice;
  JButton btnCollectMoney;
  JButton btnPrintTransactions;

  public MFNormal() {
    this.setSize(300, 300);
    this.setLayout(new GridLayout(4, 1));
    this.setTitle("Maintenance Features Normal");

    btnRestock = new JButton("Restock");
    btnChangePrice = new JButton("Change Price");
    btnCollectMoney = new JButton("Collect Money");
    btnPrintTransactions = new JButton("Print Transactions");
    this.add(btnRestock);
    this.add(btnChangePrice);
    this.add(btnCollectMoney);
    this.add(btnPrintTransactions);
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
}