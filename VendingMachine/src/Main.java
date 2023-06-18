import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    ArrayList<NormalVendingMachine> vend = new ArrayList<>();
    Currency currency = new Currency();
    Scanner sc = new Scanner(System.in);
    boolean exit = false;
    int numSlots, numItems;
    int choice;
    int i, j;
    String name;
    int quantity;
    Double price, calories;

    welcomeScreen();

    while (!exit) {
      mainMenuScreen();
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          System.out.println("Creating Vending Machine...");
          vend.add(new NormalVendingMachine());
          System.out.println("How many slots do you want in your vending machine?  >= 8 ");
          // do {
          numSlots = sc.nextInt();
          // } while (numSlots < 8);
          for (i = 0; i < numSlots; i++) {
            System.out.println("Generating Item Slot # " + (vend.get(vend.size() - 1).getSlots().size() + 1));
            vend.get(vend.size() - 1).addItemSlot();
            System.out
                .println("How many Items do you want in Slot # " + (vend.get(vend.size() - 1).getSlots().size())
                    + "? >= 10");
            // do {
            numItems = sc.nextInt();
            // } while (numItems < 10);
            for (j = 0; j < numItems; j++) {
              System.out.println("Generating Item # " + (j + 1));
              sc.nextLine();
              System.out.println("Enter Name: ");
              name = sc.nextLine();
              System.out.println("Enter Quantity: ");
              quantity = sc.nextInt();
              System.out.println("Enter Price: ");
              price = sc.nextDouble();
              System.out.println("Enter Calories: ");
              calories = sc.nextDouble();
              vend.get(vend.size() - 1).getSlots().get(i).addItem(name, quantity, price, calories);
            }
            System.out
                .println(vend.get(vend.size() - 1).getSlots().get(i).getItems().size() + " Items Successfully Added!");
          }
          System.out.println("Successfully Created Vending Machine!");

          break;

        case 2:
          break;

        case 3:
          exit = true;
          break;

        default:
          System.out.println("Invalid Choice. Please Try Again");
          break;
      }

    }

    sc.close();
  }

  public static void welcomeScreen() {
    System.out.println("Running Program...");

  }

  public static void mainMenuScreen() {
    System.out.println("[1] Create A Vending Machine");
    System.out.println("[2] Test A Vending Machine");
    System.out.println("[3] Exit Program");
    System.out.print("Enter Choice : ");

  }

  public static void exitProgram() {
    System.out.println("Exiting Program...");

  }

}