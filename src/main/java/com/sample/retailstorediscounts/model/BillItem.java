package com.sample.retailstorediscounts.model;

public class BillItem {
    private String product;
    private static float price;
    private Item item;
    private boolean grocery;

    public BillItem(String product, float price) {
        this.product = product;
        this.price = price;
    }

    public BillItem(Item item) {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public static float getPrice() {
        return price;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isGrocery() {
        return grocery;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

