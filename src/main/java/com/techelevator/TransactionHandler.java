package com.techelevator;

import java.math.BigDecimal;

public class TransactionHandler {
    private BigDecimal balance = new BigDecimal(0);

    public BigDecimal getBalance() {
        return balance;
    }

    public void add1() {
        BigDecimal bd1 = new BigDecimal("1");
        this.balance = this.balance.add(bd1);
    }

    public void add5() {
        BigDecimal bd1 = new BigDecimal("5");
        this.balance = this.balance.add(bd1);
    }
    public void add10() {
        BigDecimal bd1 = new BigDecimal("10");
        this.balance = this.balance.add(bd1);
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
        BigDecimal numOfQuarters = balance.divideToIntegralValue(quarter);
        balance = balance.subtract(numOfQuarters.multiply(quarter));
        BigDecimal dime = new BigDecimal(".1");
        BigDecimal numOfDimes = balance.divideToIntegralValue(dime);
        balance = balance.subtract(numOfQuarters.multiply(dime));
        BigDecimal nickel = new BigDecimal(".05");
        BigDecimal numOfNickels = balance.divideToIntegralValue(nickel);
        balance = balance.subtract(numOfQuarters.multiply(nickel));
        System.out.println("Your Change is" + numOfQuarters.intValue() +"Quarters" + numOfDimes.intValue() + "Dimes" + numOfNickels.intValue() + "Nickels");
    }


}
