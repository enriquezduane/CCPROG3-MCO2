package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class ReplenishMoney extends JFrame {
  JPanel currentField;
  JPanel insertedField;
  JPanel coinInsertions;
  JButton insertOne;
  JButton insertFive;
  JButton insertTen;
  JButton btnDone;
  JTextField currentOne;
  JTextField currentFive;
  JTextField currentTen;
  JTextField insertedOne;
  JTextField insertedFive;
  JTextField insertedTen;

  public ReplenishMoney() {
    this.setSize(700, 250);
    this.setLayout(new GridLayout(1, 3));
    this.setTitle("Replenish Money");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    currentField = new JPanel();
    currentField.setLayout(new GridLayout(3, 1));
    currentOne = new JTextField();
    currentOne.setEditable(false);
    currentOne.setBorder(new TitledBorder("Machine One"));
    currentFive = new JTextField();
    currentFive.setEditable(false);
    currentFive.setBorder(new TitledBorder("Machine Five"));
    currentTen = new JTextField();
    currentTen.setEditable(false);
    currentTen.setBorder(new TitledBorder("Machine Ten"));

    currentField.add(currentOne);
    currentField.add(currentFive);
    currentField.add(currentTen);

    insertedField = new JPanel();
    insertedField.setLayout(new GridLayout(3, 1));
    insertedOne = new JTextField();
    insertedOne.setEditable(false);
    insertedOne.setBorder(new TitledBorder("Inserted One"));
    insertedFive = new JTextField();
    insertedFive.setEditable(false);
    insertedFive.setBorder(new TitledBorder("Inserted Five"));
    insertedTen = new JTextField();
    insertedTen.setEditable(false);
    insertedTen.setBorder(new TitledBorder("Inserted Ten"));

    insertedField.add(insertedOne);
    insertedField.add(insertedFive);
    insertedField.add(insertedTen);

    coinInsertions = new JPanel();
    coinInsertions.setLayout(new GridLayout(3, 1));

    insertOne = new JButton("1");
    insertFive = new JButton("5");
    insertTen = new JButton("10");

    coinInsertions.add(insertOne);
    coinInsertions.add(insertFive);
    coinInsertions.add(insertTen);

    btnDone = new JButton("Done");

    this.add(currentField);
    this.add(insertedField);
    this.add(coinInsertions);
    this.add(btnDone);
    this.setLocationRelativeTo(null);
  }

  public void setInsertedFields(int one, int five, int ten) {
    insertedOne.setText("" + one);
    insertedFive.setText("" + five);
    insertedTen.setText("" + ten);
  }

  public void setCurrentFields(int one, int five, int ten) {
    currentOne.setText("" + one);
    currentFive.setText("" + ten);
    currentTen.setText("" + five);
  }

  public void addBtnOneListener(ActionListener listener) {
    insertOne.addActionListener(listener);
  }

  public void addBtnFiveListener(ActionListener listener) {
    insertFive.addActionListener(listener);
  }

  public void addBtnTenListener(ActionListener listener) {
    insertTen.addActionListener(listener);
  }

  public void addBtnDoneListener(ActionListener listener) {
    btnDone.addActionListener(listener);
  }
}
