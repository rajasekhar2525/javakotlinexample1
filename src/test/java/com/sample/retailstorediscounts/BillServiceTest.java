package com.sample.retailstorediscounts;

import com.sample.retailstorediscounts.model.Bill;
import com.sample.retailstorediscounts.model.User;
import com.sample.retailstorediscounts.model.UserType;
import com.sample.retailstorediscounts.service.BillService;
import com.sample.retailstorediscounts.service.DiscountCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BillServiceTest {

    private BillService billService;
    private DiscountCalculator discountCalculator;

    @Before
    public void setup() {
        discountCalculator = new DiscountCalculator();
        billService = new BillService(discountCalculator);
    }

    @Test
    public void testApplyDiscounts_Employee() {
        User user = new User(UserType.EMPLOYEE, 2);
        Bill bill = new Bill(user);
        bill.addItem("Item 1", 100);
        bill.addItem("Item 2", 50);

        billService.applyDiscounts(bill);

        double expectedNetPayableAmount = 115; // Assuming employee discount of 30%
        Assert.assertEquals(expectedNetPayableAmount, bill.getNetPayableAmount(), 0.001);
    }

    @Test
    public void testApplyDiscounts_Affiliate() {
        User user = new User(UserType.AFFILIATE, 3);
        Bill bill = new Bill(user);
        bill.addItem("Item 1", 200);
        bill.addItem("Item 2", 75);

        billService.applyDiscounts(bill);

        double expectedNetPayableAmount = 245; // Assuming affiliate discount of 10%
        Assert.assertEquals(expectedNetPayableAmount, bill.getNetPayableAmount(), 0.001);
    }

    // More test cases for different user types and bill scenarios...
}
