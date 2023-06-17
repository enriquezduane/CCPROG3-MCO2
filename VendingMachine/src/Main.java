import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int choice = 0;

    while (choice != 3) {
      // clearScreen();
      System.out.println("[1] Create a Vending Machine");
      System.out.println("[2] Test a Vending Machine");
      System.out.println("[3] Exit Program");
      System.out.print("> ");
      choice = sc.nextInt();
      switch (choice) {
        case 1:

          break;
        case 2:
          break;
        case 3:
          break;
        default:
          System.out.println("Invalid Choice. Please Try Again.");

      }
    }

  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}