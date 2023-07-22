package main.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends JFrame implements ActionListener {
  JPanel pnlChoice;
  JPanel pnlBack;
  JButton btnTest;
  JButton btnMaintenance;
  JButton btnBack;

  public Options(){
    this.setSize(400,300);
    this.setLayout(new GridLayout(2,1));

    this.pnlChoice = new JPanel();
    pnlChoice.setLayout(new GridLayout(1,2));
    pnlChoice.setBorder(new TitledBorder("Select Choice"));

    btnTest = new JButton("Test a Vending Machine");
    btnTest.addActionListener(this);
    btnTest.setActionCommand("TEST");

    btnMaintenance = new JButton("Maintenance Features");
    btnMaintenance.addActionListener(this);
    btnMaintenance.setActionCommand("MAINTAIN");

    pnlChoice.add(btnTest);
    pnlChoice.add(btnMaintenance);

    this.pnlBack = new JPanel();
    pnlBack.setLayout(new GridLayout(1,1));

    btnBack = new JButton("Back");
    btnBack.addActionListener(this);
    btnBack.setActionCommand("BACK");

    pnlBack.add(btnBack);
    pnlBack.setBorder(new TitledBorder("Return to Start"));

    this.add(pnlChoice);
    this.add(pnlBack);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
  }
}
