package com.example.retailstorediscounts.model

data class User(val userType: UserType, val yearsAsCustomer: Int)

enum class UserType {
    EMPLOYEE,
    AFFILIATE,
    CUSTOMER
}
