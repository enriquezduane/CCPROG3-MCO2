package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PrintTransactions extends JFrame {
  JTextArea txtTransaction;
  JButton btnDone;
  JScrollPane scrollPane;

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

  public void addBtnDone(ActionListener listener) {
    btnDone.addActionListener(listener);
  }

  public void setTransactionSummary(String summaryText) {
    txtTransaction.setText(summaryText);
  }
}
