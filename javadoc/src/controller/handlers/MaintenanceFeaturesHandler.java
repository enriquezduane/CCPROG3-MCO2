package controller.handlers;

import model.Factory;
import model.core.Currency;
import model.core.Item;
import com.view.*;

/**
 * The MaintenanceFeaturesHandler class handles user interactions with the MaintenanceFeatures view and controls the flow of the application based on user choices.
 */

public class MaintenanceFeaturesHandler {
  private MaintenanceFeatures mainteNormalFeatures;
  private Restock restockNormal;
  private Factory model;
  private ChangePrice changePrice;
  private PendingBalance pendingBalance;
  private PrintTransactions printTransactions;
  private FeatureSelector featureSelector;

   /**
     * Constructs a new MaintenanceFeaturesHandler with the provided components and model.
     * @param mainteNormalFeatures The MaintenanceFeatures view for which this handler is responsible.
     * @param restockNormal The Restock view to be shown for restocking items.
     * @param model The Factory model that will be updated based on user interactions.
     * @param changePrice The ChangePrice view to be shown for changing item prices.
     * @param pendingBalance The PendingBalance view to be shown for viewing pending balances.
     * @param printTransactions The PrintTransactions view to be shown for printing transaction summaries.
     * @param featureSelector The FeatureSelector view from which this handler is called.
     */

  public MaintenanceFeaturesHandler(MaintenanceFeatures mainteNormalFeatures, Restock restockNormal, Factory model,
      ChangePrice changePrice,
      PendingBalance pendingBalance, PrintTransactions printTransactions, FeatureSelector featureSelector) {
    this.mainteNormalFeatures = mainteNormalFeatures;
    this.restockNormal = restockNormal;
    this.model = model;
    this.changePrice = changePrice;
    this.pendingBalance = pendingBalance;
    this.printTransactions = printTransactions;
    this.featureSelector = featureSelector;

    this.mainteNormalFeatures.addBtnChangePriceListener(e -> handleChangePrice());
    this.mainteNormalFeatures.addBtnRestockListener(e -> handleRestock());
    this.mainteNormalFeatures.addBtnCollectMoneyListener(e -> handleCollectMoney());
    this.mainteNormalFeatures.addBtnPrintTransactionsListener(e -> handlePrintTransactions());
    this.mainteNormalFeatures.addBtnReturnListener(e -> handleReturn());
  }

   /**
     * Handles the "Change Price" button click event in the MaintenanceFeatures view.
     * Disposes the MaintenanceFeatures view and shows the ChangePrice view with updated data from the model.
     */
  public void handleChangePrice() {
    mainteNormalFeatures.dispose();

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

    changePrice.setDatabase(itemNames, itemQuantities, itemPrices, itemCalories);

    changePrice.setVisible(true);
  }
   /**
     * Handles the "Restock" button click event in the MaintenanceFeatures view.
     * Disposes the MaintenanceFeatures view and shows the Restock view with updated data from the model.
     */

  public void handleRestock() {
    this.mainteNormalFeatures.dispose();

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

    restockNormal.setDatabase(itemNames, itemQuantities, itemPrices, itemCalories);
    restockNormal.setVisible(true);
  }

  /**
     * Handles the "Collect Money" button click event in the MaintenanceFeatures view.
     * Disposes the MaintenanceFeatures view and shows the PendingBalance view with machine and pending currency data from the model.
     */
  public void handleCollectMoney() {
    mainteNormalFeatures.dispose();
    Currency machine = model.getMachineCurrency();
    Currency pending = model.getPendingCurrency();
    pendingBalance.setTxtFields(machine.getOne(), machine.getFive(), machine.getTen(), pending.getOne(),
        pending.getFive(), pending.getTen());
    pendingBalance.setVisible(true);
  }
   /**
     * Handles the "Print Transactions" button click event in the MaintenanceFeatures view.
     * Disposes the MaintenanceFeatures view and shows the PrintTransactions view with transaction data from the model.
     */
  public void handlePrintTransactions() {
    mainteNormalFeatures.dispose();
    String transaction = model.getTransaction();
    printTransactions.setTransactionSummary(transaction);
    printTransactions.setVisible(true);
  }
   /**
     * Handles the "Return" button click event in the MaintenanceFeatures view.
     * Disposes the MaintenanceFeatures view and shows the FeatureSelector view.
     */
  public void handleReturn() {
    mainteNormalFeatures.dispose();
    featureSelector.setVisible(true);
  }

}