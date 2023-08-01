package controller.handlers;

import javax.swing.JOptionPane;

import model.Factory;
import model.core.Currency;
import view.MaintenanceFeatures;
import view.ReplenishMoney;

public class ReplenishMoneyHandler {
  private Factory model;
  private ReplenishMoney replenishMoney;
  private MaintenanceFeatures maintenanceFeatures;

  public ReplenishMoneyHandler(ReplenishMoney replenishMoney, Factory model, MaintenanceFeatures maintenanceFeatures) {
    this.replenishMoney = replenishMoney;
    this.model = model;
    this.maintenanceFeatures = maintenanceFeatures;

    replenishMoney.addBtnDoneListener(e -> handleConfirm());
    replenishMoney.addBtnOneListener(e -> handleOne());
    replenishMoney.addBtnFiveListener(e -> handleFive());
    replenishMoney.addBtnTenListener(e -> handleTen());
  }

  public void handleConfirm() {
    JOptionPane.showMessageDialog(null, "Machine Successfully Replenished!");
    replenishMoney.dispose();
    maintenanceFeatures.setVisible(true);
  }

  public void handleOne() {
    Currency currency = model.getMachineCurrency();
    model.getMachineCurrency().setOne(currency.getOne() + 1);
    replenishMoney.setInsertedFields(currency.getOne(), currency.getFive(), currency.getTen());
  }

  public void handleFive() {
    Currency currency = model.getMachineCurrency();
    model.getMachineCurrency().setFive(currency.getFive() + 1);
    replenishMoney.setInsertedFields(currency.getOne(), currency.getFive(), currency.getTen());
  }

  public void handleTen() {
    Currency currency = model.getMachineCurrency();
    model.getMachineCurrency().setTen(currency.getTen() + 1);
    replenishMoney.setInsertedFields(currency.getOne(), currency.getFive(), currency.getTen());
  }

}
