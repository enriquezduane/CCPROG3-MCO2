package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class SlotsPrompt extends JFrame {
  JPanel pnlInput;
  JPanel pnlOptions;
  JTextField txtNumberOfSlots;
  JButton btnDone;
  JButton btnDebug;

  public SlotsPrompt() {
    this.setTitle("Slots Prompt");
    this.setSize(300, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(2, 1));

    pnlInput = new JPanel();
    pnlInput.setBorder(new TitledBorder("Enter Number of Slots (>=8)"));
    pnlInput.setLayout(new GridLayout(1, 1));

    txtNumberOfSlots = new JTextField();
    pnlInput.add(txtNumberOfSlots);

    btnDone = new JButton("Done");
    btnDebug = new JButton("Debug");

    pnlOptions = new JPanel(new GridLayout(1, 2));
    pnlOptions.add(btnDone);
    pnlOptions.add(btnDebug);

    this.add(pnlInput);
    this.add(pnlOptions);
    this.setLocationRelativeTo(null);
  }

  public int getInputSlots() {
    return Integer.parseInt(txtNumberOfSlots.getText());
  }

  public void addSlotPromptListener(ActionListener listener) {
    btnDone.addActionListener(listener);
  }

  public void addDebugListener(ActionListener listener) {
    btnDebug.addActionListener(listener);
  }
}
