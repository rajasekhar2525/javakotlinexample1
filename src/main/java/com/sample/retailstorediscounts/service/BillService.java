package com.sample.retailstorediscounts.service;

import com.sample.retailstorediscounts.model.Bill;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    private final DiscountCalculator discountCalculator;

    public BillService(DiscountCalculator discountCalculator) {

        this.discountCalculator = discountCalculator;
    }

    public float calculateNetPayableAmount(Bill bill) {

        return discountCalculator.calculateNetPayableAmount(bill);
    }

    public void applyDiscounts(Bill bill) {
        DiscountCalculator calculator = new DiscountCalculator();
        calculator.applyDiscounts(bill);
    }
}
