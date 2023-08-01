# 🏧 Vending Machine Factory Simulator (GUI)

A CCPROG3 Major Course Output to be passed on August 2, 2023 by 2:30PM.

## ✨ Features

<p align="center">
<img width="501" alt="image" src="https://github.com/enriquezduane/CCPROG3-MCO2/assets/63909110/65b80997-cbe1-40a8-8682-40fdbc2a519b">
</p>

- Create a Vending Machine

  - User is asked how many slots he wants to have in their Vending Machine (must be at least 8)
  - For each Vending Machine slot, user is prompled how many items he wants in that slot. (must be at least 10)
  - User fills in the appropriate fields for each item such as the`name`, `quantity`, `price`, and `calories`.
  - Vending Machine will be created and available for testing once all prompts are sufficed.

- Test a Vending Machine

<p align="center">
<img width="901" alt="image" src="https://github.com/enriquezduane/CCPROG3-MCO2/assets/63909110/d6f8f84d-222a-467b-8880-8cfa3e4d3970">
</p>

  - Vending Features
    - The user is greeted with the list of items within the Vending Machine and they are given the choice whether they will **buy an item** or **insert money in the vending machine.**
    - If the user chooses to insert money, they will be greeted with an interface where they will insert coins/bills per denomination just like an actual vending machine.
    - If the user chooses to buy an item, it will be bought only if the user and the machine meets the requirements.

<p align="center">
<img width="301" alt="image" src="https://github.com/enriquezduane/CCPROG3-MCO2/assets/63909110/f5a94894-d4bb-4713-923f-7b8be1f42913">
</p>

  - Maintenance Features
    - The user gets to choose whether they'd **restock an item**, **change price of an item**, **collect payments**, and **replenish the machine balance**.
    - The user can also choose to print the summary of transactions which displays the **list of items sold**, **total amount collected from the sales**, **starting inventory**, and **ending inventory**

<p align="center">
<img width="801" alt="image" src="https://github.com/enriquezduane/CCPROG3-MCO2/assets/63909110/a49b24c2-cfa0-455d-be0d-d5160f24a914">
</p>

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
