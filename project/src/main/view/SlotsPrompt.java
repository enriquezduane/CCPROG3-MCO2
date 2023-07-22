package main.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class SlotsPrompt extends JFrame {
  JPanel pnlInput;
  JTextField txtNumberOfSlots;
  JButton btnDone;
  public SlotsPrompt(){
    this.setSize(300,200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(2,1));

    pnlInput = new JPanel();
    pnlInput.setBorder(new TitledBorder("Enter Number of Slots (>=8)"));
    pnlInput.setLayout(new GridLayout(1,1));

    txtNumberOfSlots = new JTextField();
    pnlInput.add(txtNumberOfSlots);

    btnDone = new JButton("Done");

    this.add(pnlInput);
    this.add(btnDone);
    this.setVisible(true);
  }

  public int getPrompt(){
    return Integer.parseInt(txtNumberOfSlots.getText());
  }

  public void addSlotPromptListener(ActionListener listener){
    btnDone.addActionListener(listener);
  }
}
