package com.sample.retailstorediscounts.controller;

import com.sample.retailstorediscounts.model.Bill;
import com.sample.retailstorediscounts.service.BillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bill")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/calculateNetPayableAmount")
    public float calculateNetPayableAmount(@RequestBody Bill bill) {
        return billService.calculateNetPayableAmount(bill);
    }
}

