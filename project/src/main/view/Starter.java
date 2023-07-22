package main.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Starter extends JFrame{
  JPanel pnlChoice;
  JButton btnNormal;
  JButton btnSpecial;

  public Starter(){
    this.setTitle("Factory Simulator");
    this.setSize(300,200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(1,1));

    pnlChoice = new JPanel();
    pnlChoice.setBorder(new TitledBorder("Select Choice"));
    pnlChoice.setLayout(new GridLayout(1,1));

    btnNormal = new JButton("Normal");
    btnNormal.setActionCommand("NORMAL");

    btnSpecial = new JButton("Special");
    btnSpecial.setActionCommand("SPECIAL");

    pnlChoice.add(btnNormal);
    pnlChoice.add(btnSpecial);

    this.add(pnlChoice);
  }

  public void addNormalBtnListener(ActionListener listener){
    btnNormal.addActionListener(listener);
  }

  public void addSpecialBtnListener(ActionListener listener){
    btnSpecial.addActionListener(listener);
  }

}