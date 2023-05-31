// BillController.kt
package com.example.retailstorediscounts.controller

import com.example.retailstorediscounts.model.Bill
import com.example.retailstorediscounts.service.BillService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/bill")
class BillController(private val billService: BillService) {

    @PostMapping("/calculateNetPayableAmount")
    fun calculateNetPayableAmount(@RequestBody bill: Bill): Double {
        return billService.calculateNetPayableAmount(bill)
    }

    // Additional endpoints can be added here as needed
}