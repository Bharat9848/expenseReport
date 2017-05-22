package com.bharat.user.dtos;


import java.util.List;

/**
 * Created by BharatBh on 2/21/2017.
 */
public class UserExpensesDto {

    private UserDto userDto;

    private List<ExpenseDto> expenseDtoList;

    public UserExpensesDto(UserDto userDto, List<ExpenseDto> expenseDtoList) {
        this.userDto = userDto;
        this.expenseDtoList = expenseDtoList;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public List<ExpenseDto> getExpenseDtoList() {
        return expenseDtoList;
    }
}
