package com.example.retailstorediscounts.service

import com.example.retailstorediscounts.model.User
import com.example.retailstorediscounts.model.UserType
import org.springframework.stereotype.Service

@Service
class UserService {
    fun getUserById(userId: String): User? {
        // Logic to fetch user from database or any other data source
        // Return the user object if found, or null if not found
        return null
    }

    fun getUserType(userId: String): UserType? {
        val user = getUserById(userId)
        return user?.userType
    }

    fun getYearsAsCustomer(userId: String): Int? {
        val user = getUserById(userId)
        return user?.yearsAsCustomer
    }
}
