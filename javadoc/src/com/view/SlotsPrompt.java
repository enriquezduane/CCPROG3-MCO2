package com.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The SlotsPrompt class represents the graphical user interface for prompting the user to enter the number of slots
 * in the vending machine. It allows the user to enter the number of slots and provides options to proceed or
 * enter debugging mode.
 */
public class SlotsPrompt extends JFrame {
  JPanel pnlInput;
  JPanel pnlOptions;
  JTextField txtNumberOfSlots;
  JButton btnDone;
  JButton btnDebug;

  /**
   * Constructs a new SlotsPrompt frame with the specified GUI components and layout.
   */
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

  /**
   * Retrieves the number of slots entered by the user.
   *
   * @return The number of slots entered by the user as an integer.
   */
  public int getInputSlots() {
    return Integer.parseInt(txtNumberOfSlots.getText());
  }

  /**
   * Adds an ActionListener to the Done button.
   *
   * @param listener The ActionListener to be added to the Done button.
   */
  public void addSlotPromptListener(ActionListener listener) {
    btnDone.addActionListener(listener);
  }

  /**
   * Adds an ActionListener to the Debug button.
   *
   * @param listener The ActionListener to be added to the Debug button.
   */
  public void addDebugListener(ActionListener listener) {
    btnDebug.addActionListener(listener);
  }
}
