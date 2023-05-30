package com.sample.retailstorediscounts.model;

public class Item {
    private String name;
    private double price;

    private boolean isGrocery;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.isGrocery = isGrocery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isGrocery() {
        return isGrocery;
    }

}

