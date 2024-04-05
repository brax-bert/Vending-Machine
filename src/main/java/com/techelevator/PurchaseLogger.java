package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.Bidi;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PurchaseLogger {
    File file;
    PurchaseLogger(File file) {
        this.file = file;
    }
    private String getDateAndTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY hh:mm:ss a");
        return now.format(formatter);
    }

    public void logFeedMoney(BigDecimal amount, BigDecimal balance) {
        String now = getDateAndTime();
        now += " FEED MONEY: $" + amount + " $" + balance;
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))){
            writer.println(now);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public void logGiveChange(BigDecimal amount, BigDecimal balance) {
        String now = getDateAndTime();
        now += " GIVE CHANGE: $" + amount + " $" + balance;
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))){
            writer.println(now);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void logDispenseItem(Item item, BigDecimal balance) {
        String now = getDateAndTime();
        now += " " + item.name + " " + item.location + " $" + balance;
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))){
            writer.println(now);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
