package com.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The PrintTransactions class represents the graphical user interface for displaying the summary of transactions.
 * It allows the user to view the transaction summary and mark the completion with the "Done" button.
 */
public class PrintTransactions extends JFrame {
  JTextArea txtTransaction;
  JButton btnDone;
  JScrollPane scrollPane;

  /**
   * Constructs a new PrintTransactions frame with the specified GUI components and layout.
   */
  public PrintTransactions() {
    this.setSize(600, 300);
    this.setLayout(new GridLayout(1, 2));
    this.setTitle("Print Transactions");
    txtTransaction = new JTextArea(10, 30);
    txtTransaction.setLineWrap(true);
    txtTransaction.setWrapStyleWord(true);
    scrollPane = new JScrollPane(txtTransaction);

    btnDone = new JButton("Done");

    this.add(scrollPane);
    this.add(btnDone);
    this.setLocationRelativeTo(null);
  }

  /**
   * Adds an ActionListener to the Done button.
   *
   * @param listener The ActionListener to be added to the Done button.
   */
  public void addBtnDone(ActionListener listener) {
    btnDone.addActionListener(listener);
  }

  /**
   * Sets the text of the transaction summary in the text area.
   *
   * @param summaryText The summary of transactions to be displayed.
   */
  public void setTransactionSummary(String summaryText) {
    txtTransaction.setText(summaryText);
  }
}
