package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

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

  public PendingBalance() {
    this.setSize(500, 250);
    this.setLayout(new GridLayout(1, 3));
    pendingBalance = new JPanel();
    pendingBalance.setLayout(new GridLayout(3, 1));

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

  public void addBtnConfirmListener(ActionListener listener) {
    btnConfirm.addActionListener(listener);
  }

  public void setTxtFields(int machOne, int machFive, int machTen, int penOne, int penFive, int penTen) {
    machineOne.setText("" + machOne);
    machineFive.setText("" + machFive);
    machineTen.setText("" + machTen);
    pendingOne.setText("" + penOne);
    pendingFive.setText("" + penFive);
    pendingTen.setText("" + penTen);
  }

}
