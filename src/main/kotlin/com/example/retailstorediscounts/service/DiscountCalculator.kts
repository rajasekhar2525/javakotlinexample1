package com.example.retailstorediscounts.service

import com.example.retailstorediscounts.model.Bill
import com.example.retailstorediscounts.model.UserType
import org.springframework.stereotype.Service
import kotlin.math.floor

@Service
class DiscountCalculator {

    companion object {
        private const val EMPLOYEE_DISCOUNT = 0.3
        private const val AFFILIATE_DISCOUNT = 0.1
        private const val CUSTOMER_DISCOUNT = 0.05
        private const val AMOUNT_DISCOUNT_PER_100 = 5.0
    }

    fun applyDiscounts(bill: Bill) {
        if (bill.items.isEmpty()) {
            return
        }

        val totalBillAmount = calculateTotalBillAmount(bill)
        val user = bill.user

        if (!billContainsGroceryItems(bill)) {
            when (user.userType) {
                UserType.EMPLOYEE -> applyPercentageDiscount(bill, EMPLOYEE_DISCOUNT)
                UserType.AFFILIATE -> applyPercentageDiscount(bill, AFFILIATE_DISCOUNT)
                else -> {
                    if (user.yearsAsCustomer > 2) {
                        applyPercentageDiscount(bill, CUSTOMER_DISCOUNT)
                    }
                }
            }
        }


        applyAmountDiscount(bill, totalBillAmount)
    }

    private fun calculateTotalBillAmount(bill: Bill): Double {
        return bill.items.sumByDouble { it.item.price }
    }

    private fun applyPercentageDiscount(bill: Bill, discountPercentage: Double) {
        val totalBillAmount = calculateTotalBillAmount(bill)
        val discount = totalBillAmount * discountPercentage
        bill.discount += discount
    }

    private fun applyAmountDiscount(bill: Bill, totalBillAmount: Double) {
        val discount = floor(totalBillAmount / 100) * AMOUNT_DISCOUNT_PER_100
        bill.discount += discount
    }

    private fun billContainsGroceryItems(bill: Bill): Boolean {
        return bill.items.any { it.item.isGrocery }
    }
}

