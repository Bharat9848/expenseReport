package com.bharat.user.domain;

import com.bharat.user.dtos.ExpenseDto;
import com.bharat.user.dtos.UserDto;
import com.bharat.user.dtos.UserExpensesDto;
import com.bharat.user.repo.ExpenseRepository;
import com.bharat.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * Created by BharatBh on 1/31/2017.
 */
@Component
public class UserService implements IUserService{

    private UserRepository userRepository;

    private ExpenseRepository expenseRepository;

    @Autowired
    public UserService(UserRepository userRepo, ExpenseRepository expenseRepository) {
        this.userRepository = userRepo;
        this.expenseRepository = expenseRepository;
    }

    @Override
    public UserDto registerUser(User user) {
        return mapToDto(userRepository.save(user));
    }


    @Override
    public List<UserDto> findAllWithLastName(String lastName) throws ExecutionException, InterruptedException {
        return userRepository.findByLastName(lastName).join().stream().
                map(x -> mapToDto(x)).collect(Collectors.toList());
    }

    @Override
    public Expense addExpense(int  userId, Expense expense) {
        User user = userRepository.findOne(userId);
        if(user.getExpenses() == null){
            user.setExpenses(new ArrayList<>());
        }
        user.getExpenses().add(expense);
        expense.setUser(user);
        Expense expenseDb = expenseRepository.save(expense);
        return expenseDb;
    }

    @Override
    public List<Expense> getExpenses(int userId) {
        return userRepository.findExpenses(userId).join();
    }

    @Override
    public UserDto getUserById(int userId) {
        User user = userRepository.findOne(userId);
        return mapToDto(user);
    }

    @Override
    public UserExpensesDto getUserExpenseDetails(int userId) {
        return mapToUserExpenseDto(userRepository.getAllDetails(userId).join());
    }

    private UserExpensesDto mapToUserExpenseDto(User user) {
        UserDto userDto = mapToDto(user);
        List<ExpenseDto> expenseDtos = user.getExpenses().stream().
                map(ex -> mapToExpenseDto(ex)).collect(Collectors.toList());
        return new UserExpensesDto(userDto,expenseDtos);
    }

    private ExpenseDto mapToExpenseDto(Expense ex) {
        return new ExpenseDto(ex.getAmount(),ex.getDetail());
    }

    private UserDto mapToDto(User user){
        return new UserDto(user.getFirstName(),user.getLastName(),user.getId());
    }
}
