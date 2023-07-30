package controller.handlers;

import javax.swing.JOptionPane;

import model.Factory;
import model.VM.special.SpecialItems.*;
import model.core.Currency;
import model.core.Item;
import view.Customizer;
import view.VendingFeatures;

public class CustomizerHandler {
  private Customizer customizer;
  private Factory model;
  private VendingFeatures vendingFeatures;

  public CustomizerHandler(Customizer customizer, Factory model, VendingFeatures vendingFeatures) {
    this.customizer = customizer;
    this.model = model;
    this.vendingFeatures = vendingFeatures;

    this.customizer.addBtnConfirm(e -> handleConfirm());
  }

  public void handleConfirm() {
    Currency currency = model.getInsertedCurrency();
    Item item = customizer.getItem();
    Beef beef = model.getSpecialVM().getBeef();
    Pork pork = model.getSpecialVM().getPork();
    Tofu tofu = model.getSpecialVM().getTofu();
    Cabbage cabbage = model.getSpecialVM().getCabbage();
    Mushrooms mushrooms = model.getSpecialVM().getMushrooms();
    ThaiChillies thaiChillies = model.getSpecialVM().getThaiChillies();
    Sausage sausage = model.getSpecialVM().getSausage();
    Kimchi kimchi = model.getSpecialVM().getKimchi();
    int addedCalories = 0;

    if (customizer.isBeefSelected()) {
      beef.setQuantity(beef.getQuantity() - 1);
      customizer.appendStatus(beef.getMessage());
      addedCalories += beef.getCalories();
    }

    if (customizer.isPorkSelected()) {
      pork.setQuantity(pork.getQuantity() - 1);
      customizer.appendStatus(pork.getMessage());
      addedCalories += pork.getCalories();
    }

    if (customizer.isTofuSelected()) {
      tofu.setQuantity(tofu.getQuantity() - 1);
      customizer.appendStatus(tofu.getMessage());
      addedCalories += tofu.getCalories();
    }

    if (customizer.isCabbageSelected()) {
      cabbage.setQuantity(cabbage.getQuantity() - 1);
      customizer.appendStatus(cabbage.getMessage());
      addedCalories += cabbage.getCalories();
    }

    if (customizer.isMushroomsSelected()) {
      mushrooms.setQuantity(mushrooms.getQuantity() - 1);
      customizer.appendStatus(mushrooms.getMessage());
      addedCalories += mushrooms.getCalories();
    }

    if (customizer.isThaiChilliesSelected()) {
      thaiChillies.setQuantity(beef.getQuantity() - 1);
      customizer.appendStatus(thaiChillies.getMessage());
      addedCalories += thaiChillies.getCalories();
    }

    if (customizer.isSausageSelected()) {
      sausage.setQuantity(sausage.getQuantity() - 1);
      customizer.appendStatus(sausage.getMessage());
      addedCalories += sausage.getCalories();
    }

    if (customizer.isKimchiSelected()) {
      kimchi.setQuantity(kimchi.getQuantity() - 1);
      customizer.appendStatus(kimchi.getMessage());
      addedCalories += kimchi.getCalories();
    }
    customizer.appendStatus("Hotpot done!");
    customizer.appendStatus("Added Calories: " + addedCalories);
    customizer.appendStatus("Total Calories: " + (item.getCalories() + addedCalories));
    Item[] itemsList = model.getAllItems();
    String[] itemNames = new String[itemsList.length];
    int[] itemQuantities = new int[itemsList.length];
    int[] itemPrices = new int[itemsList.length];
    double[] itemCalories = new double[itemsList.length];

    for (int i = 0; i < itemsList.length; i++) {
      itemNames[i] = itemsList[i].getName();
      itemQuantities[i] = itemsList[i].getQuantity();
      itemPrices[i] = itemsList[i].getPrice();
      itemCalories[i] = itemsList[i].getCalories();
    }

    vendingFeatures.setDatabase(itemNames, itemQuantities, itemPrices, itemCalories);
    vendingFeatures.setTxtFields(currency.getOne(), currency.getFive(), currency.getTen(),
        currency.getTotalAmount());
    JOptionPane.showMessageDialog(null, "Item successfully bought!");
    customizer.dispose();
  }

}
