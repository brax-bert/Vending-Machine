package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Handler;

public class Inventory {
    private final List<Item> inventory = new ArrayList<>();

    File file = new File("vendingmachine.csv");

    PurchaseLogger logger;

    public Inventory(PurchaseLogger logger) {
        this.logger = logger;

        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splitLine = line.split("\\|");

                String location = splitLine[0];
                String name = splitLine[1];
                BigDecimal price = new BigDecimal(splitLine[2]);
                String category = splitLine[3];

                Item item;

                switch (category) {
                    case "Drink":
                        //create a drink object
                        item = new Drink(name, price, location);
                        break;
                    case "Candy":
                        //create a candy object
                        item = new Candy(name, price, location);
                        break;
                    case "Chip":
                        //create a chip object
                        item = new Chip(name, price, location);
                        break;
                    default:
                        //create a gum object
                        item = new Gum(name, price, location);
                        break;
                }
                this.inventory.add(item);
            }
        }catch (IOException e){
            System.out.println("Error reading file");

        } catch (Exception e) {
            System.out.println("An error has occurred");
        }
    }
    public List<Item> getItems() {
        return inventory;
    }
    public boolean isValidSelection(String selection) {
        for(Item item: inventory) {
            if(selection.equals(item.location)){
                return true;
            }
        }
        return false;
    }

   public void dispenseItem(Item item, TransactionHandler handler) {
        if (handler.haveEnoughMoney(item.price)) {
            handler.payForItem(item.price);
            item.qty--;
            System.out.println(item.name + " " + item.price);
            System.out.println(item.message);
            System.out.println("**********************************");
            logger.logDispenseItem(item, handler.getBalance());
        }
        else {
            System.out.println("You do not have enough money for this transaction");
        }
   }
}
