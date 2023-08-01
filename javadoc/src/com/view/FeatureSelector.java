package com.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The FeatureSelector class represents the graphical user interface for selecting between Vending Features and Maintenance Features.
 * It allows the user to choose which set of features to access.
 */
public class FeatureSelector extends JFrame {
  JPanel pnlChoice;
  JButton btnVendingFT;
  JButton btnMaintenanceFT;
  JButton btnReturn;

  /**
   * Constructs a new FeatureSelector frame with the specified GUI components and layout.
   */
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

  /**
   * Adds an ActionListener to the Vending Features button.
   *
   * @param listener The ActionListener to be added to the Vending Features button.
   */
  public void addBtnVendingFTListener(ActionListener listener) {
    btnVendingFT.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the Maintenance Features button.
   *
   * @param listener The ActionListener to be added to the Maintenance Features button.
   */
  public void addBtnMaintenanceFTListener(ActionListener listener) {
    btnMaintenanceFT.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the Return button.
   *
   * @param listener The ActionListener to be added to the Return button.
   */
  public void addBtnReturn(ActionListener listener) {
    btnReturn.addActionListener(listener);
  }
}
