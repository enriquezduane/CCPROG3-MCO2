package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class FeatureSelector extends JFrame {
  JPanel pnlChoice;
  JButton btnVendingFT;
  JButton btnMaintenanceFT;
  JButton btnReturn;

  public FeatureSelector() {
    this.setTitle("Feature Selector");
    this.setSize(500, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(1, 1));

    pnlChoice = new JPanel();
    pnlChoice.setBorder(new TitledBorder("Select Choice"));
    pnlChoice.setLayout(new GridLayout(1, 3));

    btnVendingFT = new JButton("Vending Features");
    btnMaintenanceFT = new JButton("Maintenance Features");
    btnReturn = new JButton("Return");

    pnlChoice.add(btnVendingFT);
    pnlChoice.add(btnMaintenanceFT);
    pnlChoice.add(btnReturn);

    this.add(pnlChoice);
    this.setLocationRelativeTo(null);
  }

  public void addBtnVendingFTListener(ActionListener listener) {
    btnVendingFT.addActionListener(listener);
  }

  public void addBtnMaintenanceFTListener(ActionListener listener) {
    btnMaintenanceFT.addActionListener(listener);
  }

  public void addBtnReturn(ActionListener listener) {
    btnReturn.addActionListener(listener);
  }
}