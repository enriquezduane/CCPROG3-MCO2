package main.controller;
import main.view.*;
import main.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryController {

  final private TestModel modelFactory;
  final private Starter viewStarter;
  final private SlotsPrompt viewSlotsPrompt;

  public FactoryController(TestModel model, Starter v1, SlotsPrompt v2) {
    this.modelFactory = model;
    this.viewStarter = v1;
    this.viewSlotsPrompt = v2;


    this.viewStarter.addNormalBtnListener(new NormalButtonListener());
    this.viewStarter.addSpecialBtnListener(new SpecialButtonListener());
    this.viewSlotsPrompt.addSlotPromptListener(new SlotPromptListener());

    this.viewStarter.setVisible(true);
  }

  private class NormalButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      viewSlotsPrompt.setVisible(true);
    }
  }

  private class SpecialButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      viewSlotsPrompt.setVisible(true);
    }
  }

  private class SlotPromptListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (viewSlotsPrompt.getPrompt() < 8){
        JOptionPane.showMessageDialog(null,"Please enter a valid number.");
      } else {

        System.out.println("button clicked");
        System.out.println(modelFactory.getStored());
      }
    }
  }
}
