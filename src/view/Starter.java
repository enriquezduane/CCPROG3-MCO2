package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Starter extends JFrame {
  JPanel pnlChoice;
  JButton btnCreate;
  JButton btnTest;

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
  }

  public void addBtnCreateListener(ActionListener listener) {
    btnCreate.addActionListener(listener);
  }

  public void addBtnTestListener(ActionListener listener) {
    btnTest.addActionListener(listener);
  }

}