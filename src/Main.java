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

    new FactoryController(model, v1, v2, v3, v4);
  }
}
