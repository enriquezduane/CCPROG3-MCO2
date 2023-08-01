# 🏧 Vending Machine Factory Simulator (GUI)

A CCPROG3 Major Course Output to be passed on August 2, 2023 by 2:30PM.

## ✨ Features

![image-20230802014508401](/Users/duane/Library/Application Support/typora-user-images/image-20230802014508401.png)

- Create a Vending Machine

  - User is asked how many slots he wants to have in their Vending Machine (must be at least 8)
  - For each Vending Machine slot, user is prompled how many items he wants in that slot. (must be at least 10)
  - User fills in the appropriate fields for each item such as the`name`, `quantity`, `price`, and `calories`.
  - Vending Machine will be created and available for testing once all prompts are sufficed.

- Test a Vending Machine

  ![image-20230802014621239](/Users/duane/Library/Application Support/typora-user-images/image-20230802014621239.png)
  
  - Vending Features
    - The user is greeted with the list of items within the Vending Machine and they are given the choice whether they will **buy an item** or **insert money in the vending machine.**
    - If the user chooses to insert money, they will be greeted with an interface where they will insert coins/bills per denomination just like an actual vending machine.
    - If the user chooses to buy an item, it will be bought only if the user and the machine meets the requirements.
  
    ![image-20230802014638031](/Users/duane/Library/Application Support/typora-user-images/image-20230802014638031.png)
  
  - Maintenance Features
    - The user gets to choose whether they'd **restock an item**, **change price of an item**, **collect payments**, and **replenish the machine balance**.
    - The user can also choose to print the summary of transactions which displays the **list of items sold**, **total amount collected from the sales**, **starting inventory**, and **ending inventory**
  
    ![image-20230802015038595](/Users/duane/Library/Application Support/typora-user-images/image-20230802015038595.png)
  
  - Special Features
  
    - The user can choose between different kinds of add-on items. The calorie count of the customized item is then changed depending on how much add-on items were added.

## 📝 Notes

- The program has a `Test.txt` file which is where you can choose to add your preset items for your **Normal Vending Machine**. 
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

2. Navigate to `CCPROG3-MCO2/src` and run

```
javac Main.java
```

3. Exectute the file

```
java Main
```
