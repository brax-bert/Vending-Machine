package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item{
    public Drink(String name, BigDecimal price, String location) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.qty = 5;
        this.message = "Glug, Glug, Yum!";
    }
}
