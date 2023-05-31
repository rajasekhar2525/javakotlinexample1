package com.example.retailstorediscounts.model

data class Bill(
        val user: User,
        val items: MutableList<BillItem>,
        var discount: Double = 0.0
) {
    fun addItem(itemName: String, itemPrice: Double) {
        val item = Item(itemName, itemPrice)
        val billItem = BillItem(item)
        items.add(billItem)
    }

    fun removeItem(itemName: String) {
        items.removeIf { it.item.name == itemName }
    }

    fun getTotalBillAmount(): Double {
        return items.sumByDouble { it.price }
    }

    fun getNetPayableAmount(): Double {
        val totalBillAmount = getTotalBillAmount()
        val netPayableAmount = totalBillAmount - discount
        return maxOf(netPayableAmount, 0.0)
    }
}

