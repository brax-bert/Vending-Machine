package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Item{
    public Chip(String name, BigDecimal price, String location) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.qty = 5;
        this.message = "Crunch, Crunch, Yum!";
    }

}
