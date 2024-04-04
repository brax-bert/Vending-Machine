package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item{
    public Gum(String name, BigDecimal price, String location) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.qty = 5;
        this.message = "Chew, Chew, Yum!";
    }

}
