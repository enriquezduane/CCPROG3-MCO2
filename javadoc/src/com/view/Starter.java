package com.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The Starter class represents the graphical user interface for starting the vending machine system. It allows the user
 * to choose between creating a new vending machine or testing an existing one.
 */
public class Starter extends JFrame {
  JPanel pnlChoice;
  JButton btnCreate;
  JButton btnTest;

  /**
   * Constructs a new Starter frame with the specified GUI components and layout.
   */
  public Starter() {
    this.setTitle("Starter");
    this.setSize(300, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(1, 1));

    pnlChoice = new JPanel();
    pnlChoice.setBorder(new TitledBorder("Select Choice"));
    pnlChoice.setLayout(new GridLayout(1, 1));

    btnCreate = new JButton("Create");
    btnTest = new JButton("Test");

    pnlChoice.add(btnCreate);
    pnlChoice.add(btnTest);

    this.add(pnlChoice);
    this.setLocationRelativeTo(null);
  }

  /**
   * Adds an ActionListener to the Create button.
   *
   * @param listener The ActionListener to be added to the Create button.
   */
  public void addBtnCreateListener(ActionListener listener) {
    btnCreate.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the Test button.
   *
   * @param listener The ActionListener to be added to the Test button.
   */
  public void addBtnTestListener(ActionListener listener) {
    btnTest.addActionListener(listener);
  }
}
