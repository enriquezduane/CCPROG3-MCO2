package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class TypeSelector extends JFrame {
  JPanel pnlChoice;
  JButton btnNormal;
  JButton btnSpecial;

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
  }

  public void addBtnNormalListener(ActionListener listener) {
    btnNormal.addActionListener(listener);
  }

  public void addBtnSpecialListener(ActionListener listener) {
    btnSpecial.addActionListener(listener);
  }
}