import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// view method
public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    Factory factory = new Factory();
    File file = new File("/Users/duane/Documents/repositories/CCPROG3-MCO1/preset/Test.txt");
    Scanner sc = new Scanner(System.in);
    Scanner debug = new Scanner(file);
    boolean exit = false;
    int i, j, choice, quantity[], price[], numSlots, numItems, newQuantity, newPrice;
    int balance[] = new int[6];
    String name[], item;
    double calories[];

    while (!exit) {
      clearScreen();
      // welcomeScreen();
      mainMenuScreen();
      choice = Integer.parseInt(sc.nextLine());
      switch (choice) {
        case 1:
          clearScreen();

          System.out.println("[1] Regular Vending Machine");
          System.out.println("[2] Special Vending Machine (NOT YET AVAILABLE)");
          System.out.print("Enter Choice: ");
          choice = Integer.parseInt(debug.nextLine());
          clearScreen();
          factory.createVendingMachine();

          clearScreen();
          System.out.print("Number of Slots? (>= 8) : ");
          numSlots = Integer.parseInt(debug.nextLine());

          for (i = 0; i < numSlots; i++) {
            clearScreen();
            System.out.print("Number of Items in this Slot #" + (i + 1) + "? ( >= 10 ) : ");
            numItems = Integer.parseInt(debug.nextLine());

            name = new String[numItems];
            quantity = new int[numItems];
            price = new int[numItems];
            calories = new double[numItems];

            for (j = 0; j < numItems; j++) {
              clearScreen();
              System.out.println("Enter details for Item #" + (j + 1) + ": ");
              System.out.print("Name: ");
              name[j] = debug.nextLine();

              System.out.print("Quantity: ");
              quantity[j] = Integer.parseInt(debug.nextLine());
              System.out.print("Price: ");
              price[j] = Integer.parseInt(debug.nextLine());
              System.out.print("Calories: ");
              calories[j] = Double.parseDouble(debug.nextLine());
              factory.getMostRecentVend().getTransactionSummary().addStartingInventory(quantity[j]);
            }
            System.out.println("\nCreating Item Slot...");
            factory.createItemSlot(name, quantity, price, calories);
            System.out.println("Item Slot #" + (j + 1) + " Created!");
          }
          clearScreen();
          factory.getMostRecentVend().getTransactionSummary().setEndingInventory(
              factory.getMostRecentVend().getTransactionSummary().getStartingInventory());

          System.out.println("Vending Machine Successfully created.");
          pressEnterToContinue();
          break;

        case 2:
          do {
            clearScreen();
            System.out.println("[1] Vending Features");
            System.out.println("[2] Maintenance Features");
            choice = Integer.parseInt(sc.nextLine());
          } while (choice != 1 && choice != 2);

          if (choice == 1) {
            do {
              factory.showAllItems();
              System.out.println(
                  "Amount Inserted = " + factory.getMostRecentVend().getInsertedBalance());
              System.out.println("[1] Insert Money");
              System.out.println("[2] Buy Item");
              System.out.println("[0] Exit");
              choice = Integer.parseInt(sc.nextLine());
              if (choice == 1) {
                for (i = 0; i < balance.length; i++) {
                  balance[i] = 0;
                }
                while (choice != 7) {
                  clearScreen();
                  System.out.println("[1] 1"
                      + "    - Inserted: " + balance[0]);
                  System.out.println("[2] 5"
                      + "    - Inserted: " + balance[1]);
                  System.out.println("[3] 10"
                      + "   - Inserted: " + balance[2]);
                  System.out.println("[4] 20"
                      + "   - Inserted: " + balance[3]);
                  System.out.println("[5] 50"
                      + "   - Inserted: " + balance[4]);
                  System.out.println("[6] 100"
                      + "  - Inserted: " + balance[5]);
                  System.out.println("[7] Confirm");
                  choice = Integer.parseInt(sc.nextLine());
                  switch (choice) {
                    case 1:
                      balance[0] += 1;
                      break;
                    case 2:
                      balance[1] += 1;
                      break;
                    case 3:
                      balance[2] += 1;
                      break;
                    case 4:
                      balance[3] += 1;
                      break;
                    case 5:
                      balance[4] += 1;
                      break;
                    case 6:
                      balance[5] += 1;
                      break;
                  }
                }
                factory.insertMoney(balance);
              } else if (choice == 2) {
                System.out.print("Enter Item to Buy: ");
                item = sc.nextLine();
                clearScreen();
                System.out.println("Attempting to buy item...");
                if (factory.buyItem(item) == true) {
                  System.out.println("Successfully Bought Item");
                }
                pressEnterToContinue();
              }
            } while (choice != 0);
          } else if (choice == 2) {
            while (choice != 0) {
              clearScreen();
              System.out.println("[1] Restock Item");
              System.out.println("[2] Change Price of Item");
              System.out.println("[3] Collect Money");
              System.out.println("[4] Replenish Money");
              System.out.println("[5] Print Transaction Summary");
              System.out.println("[0] Exit");
              choice = Integer.parseInt(sc.nextLine());
              switch (choice) {
                case 1:
                  clearScreen();
                  factory.showAllItems();
                  System.out.print("Item to Restock: ");
                  item = sc.nextLine();
                  System.out.print("Quantity to Stock: ");
                  newQuantity = Integer.parseInt(sc.nextLine());
                  System.out.println("Restocking...");
                  factory.getMostRecentVend().getTransactionSummary().addEndingInventory(
                      newQuantity);
                  factory.restock(item, newQuantity);
                  System.out.println("Successfully Restocked!");
                  pressEnterToContinue();
                  break;

                case 2:
                  clearScreen();
                  factory.showAllItems();
                  System.out.print("Item to change Price: ");
                  item = sc.nextLine();
                  System.out.print("New Price: ");
                  newPrice = Integer.parseInt(sc.nextLine());
                  System.out.println("Changing item price...");
                  factory.changePrice(item, newPrice);
                  System.out.println("Price successfully changed!");
                  pressEnterToContinue();
                  break;

                case 3:
                  clearScreen();
                  factory.displayPendingBalance();
                  System.out.println("Transferring funds to Machine...");
                  factory.transferBalance();
                  System.out.println("Success!");
                  pressEnterToContinue();
                  break;

                case 4:
                  clearScreen();
                  for (i = 0; i < balance.length; i++) {
                    balance[i] = 0;
                  }
                  while (choice != 7) {
                    clearScreen();
                    factory.displayVendingMachineBalance();
                    System.out.println("\n[1] 1"
                        + "    - Inserted: " + balance[0]);
                    System.out.println("[2] 5"
                        + "    - Inserted: " + balance[1]);
                    System.out.println("[3] 10"
                        + "   - Inserted: " + balance[2]);
                    System.out.println("[4] 20"
                        + "   - Inserted: " + balance[3]);
                    System.out.println("[5] 50"
                        + "   - Inserted: " + balance[4]);
                    System.out.println("[6] 100"
                        + "  - Inserted: " + balance[5]);
                    System.out.println("[7] Confirm");
                    choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                      case 1:
                        balance[0] += 1;
                        break;
                      case 2:
                        balance[1] += 1;
                        break;
                      case 3:
                        balance[2] += 1;
                        break;
                      case 4:
                        balance[3] += 1;
                        break;
                      case 5:
                        balance[4] += 1;
                        break;
                      case 6:
                        balance[5] += 1;
                        break;
                    }
                  }
                  factory.getMostRecentVend().getMachineCurrency().replenishMoney(balance);
                  break;

                case 5:
                  clearScreen();
                  System.out.println("Fetching Tranasaction Summary...");
                  factory.displayTransactionSummary();
                  pressEnterToContinue();
                  break;
                default:
                  break;
              }
            }
          }

          break;

        case 3:
          exit = true;
          break;

        default:
          System.out.println("Invalid Choice. Please Try Again");
          break;
      }
    }
    exitProgram();
    sc.close();
    debug.close();
  }

  private static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private static void mainMenuScreen() {
    System.out.println("[1] Create A Vending Machine");
    System.out.println("[2] Test A Vending Machine");
    System.out.println("[3] Exit Program");
    System.out.print("Enter Choice : ");
  }

  private static void exitProgram() {
    System.out.println("Exiting Program...");
  }

  private static void pressEnterToContinue() {
    System.out.print("Press Enter Key to continue... ");
    try {
      System.in.read();
    } catch (Exception e) {
    }
  }
}
