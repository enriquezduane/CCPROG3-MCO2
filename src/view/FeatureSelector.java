package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class FeatureSelector extends JFrame {
  JPanel pnlChoice;
  JButton btnVendingFT;
  JButton btnMaintenanceFT;

  public FeatureSelector() {
    this.setTitle("Factory Simulator");
    this.setSize(400, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(1, 1));

    pnlChoice = new JPanel();
    pnlChoice.setBorder(new TitledBorder("Select Choice"));
    pnlChoice.setLayout(new GridLayout(1, 1));

    btnVendingFT = new JButton("Vending Features");
    btnMaintenanceFT = new JButton("Maintenance Features");

    pnlChoice.add(btnVendingFT);
    pnlChoice.add(btnMaintenanceFT);

    this.add(pnlChoice);
  }

  public void addBtnVendingFTListener(ActionListener listener) {
    btnVendingFT.addActionListener(listener);
  }

  public void addBtnMaintenanceFTListener(ActionListener listener) {
    btnMaintenanceFT.addActionListener(listener);
  }
}