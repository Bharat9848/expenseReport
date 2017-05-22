package com.bharat.user.domain;

import com.bharat.user.dtos.UserDto;
import com.bharat.user.dtos.UserExpensesDto;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by BharatBh on 2/16/2017.
 */
public interface IUserService {

    List<UserDto> findAllWithLastName(String lastName) throws ExecutionException, InterruptedException;

    UserDto registerUser(User user);

    Expense addExpense(int userId, Expense expense );

    List<Expense> getExpenses(int userId);

    UserDto getUserById(int userId);

    UserExpensesDto getUserExpenseDetails(int userId);
}
