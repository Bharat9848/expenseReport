package com.bharat.user.dtos;

import com.bharat.user.domain.User;

/**
 * Created by BharatBh on 2/21/2017.
 */
public class ExpenseDto {

//    private int id;

    private double amount;

    private String detail;

    public ExpenseDto(Double amount, String detail) {
        this.amount = amount;
        this.detail = detail;
    }

//    public int getId() {
//        return id;
//    }

    public double getAmount() {
        return amount;
    }

    public String getDetail() {
        return detail;
    }

}
