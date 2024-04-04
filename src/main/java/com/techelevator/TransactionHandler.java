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
}
