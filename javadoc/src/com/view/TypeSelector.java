package com.
view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The TypeSelector class represents the graphical user interface for selecting the type of vending machine.
 * It allows the user to choose between a normal vending machine or a special vending machine.
 */
public class TypeSelector extends JFrame {
  JPanel pnlChoice;
  JButton btnNormal;
  JButton btnSpecial;

  /**
   * Constructs a new TypeSelector frame with the specified GUI components and layout.
   */
  public TypeSelector() {
    this.setTitle("Type Selector");
    this.setSize(300, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(1, 1));

    pnlChoice = new JPanel();
    pnlChoice.setBorder(new TitledBorder("Select Choice"));
    pnlChoice.setLayout(new GridLayout(1, 1));

    btnNormal = new JButton("Normal");
    btnSpecial = new JButton("Special");

    pnlChoice.add(btnNormal);
    pnlChoice.add(btnSpecial);

    this.add(pnlChoice);
    this.setLocationRelativeTo(null);
  }

  /**
   * Adds an ActionListener to the Normal button.
   *
   * @param listener The ActionListener to be added to the Normal button.
   */
  public void addBtnNormalListener(ActionListener listener) {
    btnNormal.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the Special button.
   *
   * @param listener The ActionListener to be added to the Special button.
   */
  public void addBtnSpecialListener(ActionListener listener) {
    btnSpecial.addActionListener(listener);
  }
}
