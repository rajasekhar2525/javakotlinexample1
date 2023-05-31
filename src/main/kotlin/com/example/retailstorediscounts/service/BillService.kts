package com.example.retailstorediscounts.service

import com.example.retailstorediscounts.model.Bill
import org.springframework.stereotype.Service

@Service
class BillService(private val discountCalculator: DiscountCalculator) {

    fun calculateNetPayableAmount(bill: Bill): Double {
        return discountCalculator.calculateNetPayableAmount(bill)
    }

    fun applyDiscounts(bill: Bill) {
        discountCalculator.applyDiscounts(bill)
    }
}