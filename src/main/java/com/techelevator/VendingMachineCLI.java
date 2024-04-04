package com.techelevator;

import java.util.*;

public class VendingMachineCLI {
    Inventory inventory;
    Scanner inputScanner = new Scanner(System.in);
    TransactionHandler handler = new TransactionHandler();
    VendingMachineCLI(Inventory inventory){
        this.inventory = inventory;
    }
    public void mainMenu() {
        while (true) {
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            String input = inputScanner.nextLine();

            switch (input) {
                case "1":
                    displayItems();
                    break;
                case "2":
                    purchaseMenu();
                    break;
                case "3":
                    System.out.println("Thank you for using the Vendo-Matic 800!");
                    return;
                default :
                    System.out.println("Not a valid entry. Please try again");
                    break;
            }
        }
    }

    public void displayItems() {
        List<Item> itemList = inventory.getItems();
        for (Item item: itemList) {
            String qtyDisplay = Integer.toString(item.qty);
            if (item.qty == 0) {
                qtyDisplay = "SOLD OUT";
            }
            System.out.println(item.location + ": " + item.name + " " + item.price + " qty " + qtyDisplay);
        }
        System.out.println("**********************************");
    }

    public void purchaseMenu() {
        while (true) {
            System.out.println("Your Current Balance is $" + handler.getBalance());
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            String input = inputScanner.nextLine();

            switch (input) {
                case "1":
                    feedMoney();
                    break;
                case "2":
                    makeSelection();
                    break;
                case "3":
                    handler.finishTransaction();
                    break;
                default :
                    System.out.println("Not a valid entry. Please try again");
                    break;
            }
        }
    }

    public void feedMoney() {
        System.out.println("Your Current Balance is $" + handler.getBalance());
        System.out.println("(1) Add $1.00");
        System.out.println("(2) Add $5.00");
        System.out.println("(3) Add $10.00");
        String input = inputScanner.nextLine();

        switch (input) {
            case "1":
                handler.add1();
                break;
            case "2":
                handler.add5();
                break;
            case "3":
                handler.add10();
                break;
            default :
                System.out.println("Not a valid entry. Please try again");
                break;
        }
    }
    public void makeSelection() {
        displayItems();
        System.out.println("Please enter a selection");
        String selection = inputScanner.nextLine();
        boolean validSelection = inventory.isValidSelection(selection);
        if(!validSelection){
            System.out.println("Please enter a valid selection");
        } else {
            for(Item item: inventory.getItems()) {
                if(selection.equals(item.location) && item.qty == 0) {
                    System.out.println(item.name + " is SOLD OUT");
                }else if(selection.equals(item.location) ) {
                    inventory.dispenseItem(item, handler);
                }
            }

        }

//        Show the list of products available and allow the customer to enter a code to select an item.
//        If the product code doesn't exist, the vending machine informs the customer and returns them to the Purchase menu.
//        If a product is currently sold out, the vending machine informs the customer and returns them to the Purchase menu.
//        If a customer selects a valid product, it's dispensed to the customer.
//        Dispensing an item prints the item name, cost, and the money remaining. Dispensing also returns a message.
//        After the machine dispenses the product, the machine must update its balance accordingly and return the customer to the Purchase menu.

    }
}
