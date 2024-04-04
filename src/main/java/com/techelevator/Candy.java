package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item{
    public Candy(String name, BigDecimal price, String location) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.qty = 5;
        this.message = "Munch, Munch, Yum!";
    }

}
