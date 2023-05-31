package com.example.retailstorediscounts.model

data class BillItem(val item: Item) {
    val price: Double
        get() = item.price
}

