package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import model.core.Item;

import java.awt.*;
import java.awt.event.ActionListener;

public class Customizer extends JFrame {
  JRadioButton rbBeef;
  JRadioButton rbPork;
  JRadioButton rbTofu;
  JRadioButton rbMushrooms;
  JRadioButton rbCabbage;
  JRadioButton rbThaiChillies;
  JRadioButton rbSausage;
  JRadioButton rbKimchi;
  JButton confirm;
  JPanel pnlButtons;
  JTextArea status;
  Item item;

  public Customizer() {
    this.setTitle("Hotpot Customizer");
    this.setLayout(new GridLayout(1, 3));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(800, 300);

    pnlButtons = new JPanel();
    pnlButtons.setLayout(new GridLayout(8, 1));
    pnlButtons.setBorder(new TitledBorder("Select Items"));

    rbBeef = new JRadioButton("Beef");
    rbPork = new JRadioButton("Pork");
    rbTofu = new JRadioButton("Tofu");
    rbCabbage = new JRadioButton("Cabbage");
    rbMushrooms = new JRadioButton("Mushrooms");
    rbThaiChillies = new JRadioButton("Thai Chillies");
    rbSausage = new JRadioButton("Sausage");
    rbKimchi = new JRadioButton("Kimchi");

    confirm = new JButton("Confirm");

    pnlButtons.add(rbBeef);
    pnlButtons.add(rbPork);
    pnlButtons.add(rbTofu);
    pnlButtons.add(rbCabbage);
    pnlButtons.add(rbMushrooms);
    pnlButtons.add(rbThaiChillies);
    pnlButtons.add(rbSausage);
    pnlButtons.add(rbKimchi);

    status = new JTextArea();
    status.setBorder(new TitledBorder("Status"));

    this.add(pnlButtons);
    this.add(confirm);
    this.add(status);
    this.setLocationRelativeTo(null);
  }

  public boolean isBeefSelected() {
    return rbBeef.isSelected();
  }

  public boolean isPorkSelected() {
    return rbPork.isSelected();
  }

  public boolean isTofuSelected() {
    return rbTofu.isSelected();
  }

  public boolean isCabbageSelected() {
    return rbCabbage.isSelected();
  }

  public boolean isMushroomsSelected() {
    return rbMushrooms.isSelected();
  }

  public boolean isThaiChilliesSelected() {
    return rbThaiChillies.isSelected();
  }

  public boolean isSausageSelected() {
    return rbSausage.isSelected();
  }

  public boolean isKimchiSelected() {
    return rbKimchi.isSelected();
  }

  public void addBtnConfirm(ActionListener listener) {
    confirm.addActionListener(listener);
  }

  public void appendStatus(String statusText) {
    status.append(statusText + "\n");
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Item getItem() {
    return item;
  }
}
