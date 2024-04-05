package com.techelevator;

import java.math.BigDecimal;

public class TransactionHandler {
    private BigDecimal balance = new BigDecimal(0);
    PurchaseLogger logger;

    public TransactionHandler(PurchaseLogger logger){
        this.logger = logger;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    public void add1() {
        BigDecimal bd1 = new BigDecimal("1");
        this.balance = this.balance.add(bd1);
        logger.logFeedMoney(bd1, balance);
    }
    public void add5() {
        BigDecimal bd1 = new BigDecimal("5");
        this.balance = this.balance.add(bd1);
        logger.logFeedMoney(bd1, balance);
    }
    public void add10() {
        BigDecimal bd1 = new BigDecimal("10");
        this.balance = this.balance.add(bd1);
        logger.logFeedMoney(bd1, balance);
    }
    public void payForItem(BigDecimal price) {
        this.balance = this.balance.subtract(price);
    }

    public boolean haveEnoughMoney(BigDecimal price) {
       if ( balance.compareTo(price) > 0 ) {
           return true;
       }
       return false;
    }

    public void finishTransaction() {
        BigDecimal quarter = new BigDecimal(".25");
        BigDecimal dime = new BigDecimal(".10");
        BigDecimal nickel = new BigDecimal(".05");
        BigDecimal change = balance;

        BigDecimal numOfQuarters = balance.divideToIntegralValue(quarter);
        balance = balance.subtract(numOfQuarters.multiply(quarter));
        BigDecimal numOfDimes = balance.divideToIntegralValue(dime);
        balance = balance.subtract(numOfDimes.multiply(dime));
        BigDecimal numOfNickels = balance.divideToIntegralValue(nickel);
        balance = balance.subtract(numOfNickels.multiply(nickel));

        System.out.println("Your Change is " + numOfQuarters.intValue() +" Quarters, " + numOfDimes.intValue() + " Dimes, and " + numOfNickels.intValue() + " Nickels.");
        logger.logGiveChange(change, balance);
    }
}
