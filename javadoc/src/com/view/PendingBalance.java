package com.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * The PendingBalance class represents the graphical user interface for displaying the pending balance and machine balance of the vending machine.
 * It allows the user to confirm the collected money.
 */
public class PendingBalance extends JFrame {
  JPanel pendingBalance;
  JPanel machineBalance;
  JButton btnConfirm;
  JTextField machineOne;
  JTextField machineFive;
  JTextField machineTen;
  JTextField pendingOne;
  JTextField pendingFive;
  JTextField pendingTen;

  /**
   * Constructs a new PendingBalance frame with the specified GUI components and layout.
   */
  public PendingBalance() {
    this.setSize(500, 250);
    this.setLayout(new GridLayout(1, 3));
    pendingBalance = new JPanel();
    pendingBalance.setLayout(new GridLayout(3, 1));
    this.setTitle("Collect Money");

    pendingOne = new JTextField();
    pendingOne.setBorder(new TitledBorder("Pending One"));
    pendingFive = new JTextField();
    pendingFive.setBorder(new TitledBorder("Pending Five"));
    pendingTen = new JTextField();
    pendingTen.setBorder(new TitledBorder("Pending Ten"));

    pendingBalance.add(pendingOne);
    pendingBalance.add(pendingFive);
    pendingBalance.add(pendingTen);

    machineBalance = new JPanel();
    machineBalance.setLayout(new GridLayout(3, 1));

    machineOne = new JTextField();
    machineOne.setBorder(new TitledBorder("Machine One"));
    machineFive = new JTextField();
    machineFive.setBorder(new TitledBorder("Machine Five"));
    machineTen = new JTextField();
    machineTen.setBorder(new TitledBorder("Machine Ten"));

    machineBalance.add(machineOne);
    machineBalance.add(machineFive);
    machineBalance.add(machineTen);

    btnConfirm = new JButton("Confirm");

    this.add(pendingBalance);
    this.add(machineBalance);
    this.add(btnConfirm);

    this.setLocationRelativeTo(null);
  }

  /**
   * Adds an ActionListener to the Confirm button.
   *
   * @param listener The ActionListener to be added to the Confirm button.
   */
  public void addBtnConfirmListener(ActionListener listener) {
    btnConfirm.addActionListener(listener);
  }

  /**
   * Sets the text fields with the specified machine and pending balance amounts.
   *
   * @param machOne The amount of one unit in the machine balance.
   * @param machFive The amount of five units in the machine balance.
   * @param machTen The amount of ten units in the machine balance.
   * @param penOne The amount of one unit in the pending balance.
   * @param penFive The amount of five units in the pending balance.
   * @param penTen The amount of ten units in the pending balance.
   */
  public void setTxtFields(int machOne, int machFive, int machTen, int penOne, int penFive, int penTen) {
    machineOne.setText("" + machOne);
    machineFive.setText("" + machFive);
    machineTen.setText("" + machTen);
    pendingOne.setText("" + penOne);
    pendingFive.setText("" + penFive);
    pendingTen.setText("" + penTen);
  }
}
