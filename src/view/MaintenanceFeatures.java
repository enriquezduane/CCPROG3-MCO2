package view;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class MaintenanceFeatures extends JFrame {
  JButton btnRestock;
  JButton btnChangePrice;
  JButton btnCollectMoney;
  JButton btnReplenishMoney;
  JButton btnPrintTransactions;
  JButton btnReturn;

  public MaintenanceFeatures() {
    this.setSize(300, 300);
    this.setLayout(new GridLayout(6, 1));
    this.setTitle("Maintenance Features");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    btnRestock = new JButton("Restock");
    btnChangePrice = new JButton("Change Price");
    btnCollectMoney = new JButton("Collect Money");
    btnReplenishMoney = new JButton("Replenish Money");
    btnPrintTransactions = new JButton("Print Transactions");
    btnReturn = new JButton("Return");
    this.add(btnRestock);
    this.add(btnChangePrice);
    this.add(btnCollectMoney);
    this.add(btnReplenishMoney);
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

  public void addBtnReplenishMoneyListener(ActionListener listener) {
    btnReplenishMoney.addActionListener(listener);
  }

  public void addBtnPrintTransactionsListener(ActionListener listener) {
    btnPrintTransactions.addActionListener(listener);
  }

  public void addBtnReturnListener(ActionListener listener) {
    btnReturn.addActionListener(listener);
  }
}