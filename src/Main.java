import model.*;
import view.*;
import controller.*;

public class Main {
  public static void main(String[] args) {
    Factory model = new Factory();
    Starter v1 = new Starter();
    TypeSelector v2 = new TypeSelector();
    SlotsPrompt v3 = new SlotsPrompt();
    InsertItems v4 = new InsertItems();
    FeatureSelector v5 = new FeatureSelector();
    VendingFeatures v6 = new VendingFeatures();
    MaintenanceFeatures v7 = new MaintenanceFeatures();
    Restock v8 = new Restock();
    ChangePrice v9 = new ChangePrice();
    PendingBalance v10 = new PendingBalance();
    PrintTransactions v11 = new PrintTransactions();
    new FactoryController(model, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11);
  }
}
