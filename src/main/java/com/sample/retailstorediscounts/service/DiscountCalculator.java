package com.sample.retailstorediscounts.service;

import com.sample.retailstorediscounts.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountCalculator {
    private static final double EMPLOYEE_DISCOUNT = 0.3;
    private static final double AFFILIATE_DISCOUNT = 0.1;
    private static final double CUSTOMER_DISCOUNT = 0.05;
    private static final double AMOUNT_DISCOUNT_PER_100 = 5.0;

    public void applyDiscounts(Bill bill) {
        if (bill.getItems().isEmpty()) {
            return;
        }

        double totalBillAmount = calculateTotalBillAmount(bill);
        User user = bill.getUser();

        if (!billContainsGroceryItems(bill)) {
            if (user.getUserType() == UserType.EMPLOYEE) {
                applyPercentageDiscount(bill, EMPLOYEE_DISCOUNT);
            } else if (user.getUserType() == UserType.AFFILIATE) {
                applyPercentageDiscount(bill, AFFILIATE_DISCOUNT);
            } else if (user.isCustomerOver2Years()) {
                applyPercentageDiscount(bill, CUSTOMER_DISCOUNT);
            }
        }

        applyAmountDiscount(bill, totalBillAmount);
    }

    private double calculateTotalBillAmount(Bill bill) {
        return bill.getItems().stream()
                .mapToDouble(item -> item.getItem().getPrice())
                .sum();
    }


    private void applyPercentageDiscount(Bill bill, double discountPercentage) {
        double totalBillAmount = calculateTotalBillAmount(bill);
        double discount = totalBillAmount * discountPercentage;
        bill.setDiscount(discount);
    }

    private void applyAmountDiscount(Bill bill, double totalBillAmount) {
        double discount = Math.floor(totalBillAmount / 100) * AMOUNT_DISCOUNT_PER_100;
        bill.setDiscount(bill.getDiscount() + discount);
    }

    private boolean billContainsGroceryItems(Bill bill) {
        for (BillItem item1 : bill.getItems()) {
            if (item1.getItem().isGrocery()) {
                return true;
            }
        }
        return false;
    }
}