package com.sample.retailstorediscounts.model;

public class User {
    private UserType userType;
    private int yearsAsCustomer;

    public User(UserType userType, int yearsAsCustomer) {
        this.userType = userType;
        this.yearsAsCustomer = yearsAsCustomer;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getYearsAsCustomer() {
        return yearsAsCustomer;
    }

    public void setYearsAsCustomer(int yearsAsCustomer) {
        this.yearsAsCustomer = yearsAsCustomer;
    }

    public boolean isCustomerOver2Years() {
        return yearsAsCustomer > 2;
    }
}

