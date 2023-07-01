# 🏧 Vending Machine Factory Simulator (CLI)

A CCPROG3 Major Course Output to be passed on July 1, 2023 by 9:30PM.

## ✨ Features

- Create a Vending Machine

  - User is asked how many slots he wants to have in their Vending Machine (must be at least 8)
  - For each Vending Machine slot, user is prompled how many items he wants in that slot. (must be at least 10)
  - User fills in the appropriate fields for each item such as the`name`, `quantity`, `price`, and `calories`.
  - Vending Machine will be created and available for testing once all prompts are sufficed.

- Test a Vending Machine

  - Vending Features
    - The user is greeted with the list of items within the Vending Machine and they are given the choice whether they will **buy an item** or **insert money in the vending machine.**
    - If the user chooses to insert money, they will be greeted with an interface where they will insert coins/bills per denomination just like an actual vending machine.
    - If the user chooses to buy an item, it will be bought only if the user and the machine meets the requirements.

  - Maintenance Features
    - The user gets to choose whether they'd **restock an item**, **change price of an item**, **collect payments**, and **replenish the machine balance**.
    - The user can also choose to print the summary of transactions which displays the **list of items sold**, **total amount collected from the sales**, **starting inventory**, and **ending inventory**

## 📝 Notes

- Only the most recent vending machine is maintained by the Factory.
- There are 2 versions of the program, the **actual** program gives you the freedom to create your own item slots and items. However, for testing, it may be a bit tedious. To work around this issue, we've modified the part of the code where the creation of the vending machine is done and made a **preset** version of a program which makes use of the `Test.txt` file to automate the process.
- The `Test.txt` file follows the format:

```
<normal_or_special>
<num_slots>
<num_item_in_slot1>
<item1_name>
<item1_price>
<item1_quantity>
<item1_price>
<item1_calories>
...
<itemN_name>
<itemN_price>
<itemN_quantity>
<itemN_price>
<itemN_calories>
...
<num_item_in_slotN>
<item1_name>
<item1_price>
<item1_quantity>
<item1_price>
<item1_calories>
...
<itemN_name>
<itemN_price>
<itemN_quantity>
<itemN_price>
<itemN_calories>
```

## 🚀 Usage

1. Clone the repository using the `git clone` command

```
git clone https://github.com/enriquezduane/CCPROG3-MCO1.git
```

2. Go to either the **actual** or **preset** version of the program and run `Main`

```
java Main
```

NOTE: You can recompile the program using `javac`

```
javac Main.java
```

3. If you are going to use the **preset** version of the program, make sure to modify `Main.java` and change the path of the `Test.txt` file from this line of code:

```
File file = new File("/path/to/Test.txt");
```

## 🩹 Issues

- In Windows, `clearScreen()` and `pressEnterToContinue()` won't work properly with the **preset** version of the program. To work around this issue, just remove all the methods in `Main.java`
