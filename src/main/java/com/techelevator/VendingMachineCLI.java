package com.techelevator;

import java.util.*;

public class VendingMachineCLI {
    Inventory inventory;
    Scanner inputScanner = new Scanner(System.in);
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
                    //call display method
                    break;
                case "2":
                    System.out.println("purchase method called");
                    //call purchase method
                    break;
                case "3":
                    System.out.println("Thank you for using the Vendo-Matic 800!");
                    //exit
                    return;
                default:
                    //display message to user
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
}
