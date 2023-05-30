package com.sample.retailstorediscounts.model;

import com.sample.retailstorediscounts.service.DiscountCalculator;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private User user;
    private List<BillItem> items;
    private double discount;

    public Bill(User user) {
        this.user = user;
        this.items = new ArrayList<>();
        this.discount = 0.0;
    }

    public User getUser() {
        return user;
    }

    public List<BillItem> getItems() {
        return items;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void addItem(String itemName, double itemPrice) {
        Item item = new Item(itemName, itemPrice);
        BillItem billItem = new BillItem(item);
        items.add(billItem);
    }

    public void removeItem(String itemName) {
        items.removeIf(billItem -> billItem.getItem().getName().equals(itemName));
    }

    public double getTotalBillAmount() {
        double totalAmount = 0.0;
        for (BillItem billItem : items) {
            totalAmount += billItem.getPrice();
        }
        return totalAmount;
    }

    public double getNetPayableAmount() {
        double totalBillAmount = getTotalBillAmount();
        double netPayableAmount = totalBillAmount - discount;
        return Math.max(netPayableAmount, 0.0);
    }
}
