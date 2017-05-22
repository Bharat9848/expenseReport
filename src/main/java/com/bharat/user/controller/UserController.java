package com.bharat.user.controller;

import com.bharat.user.domain.Expense;
import com.bharat.user.domain.IUserService;
import com.bharat.user.domain.User;
import com.bharat.user.dtos.UserDto;
import com.bharat.user.dtos.UserExpensesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by BharatBh on 2/16/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UserDto> addUser(@RequestBody User userArg){
        UserDto user = userService.registerUser(userArg);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getUserWithLastName(@RequestParam String lastName) throws ExecutionException, InterruptedException {
        List<UserDto> users = userService.findAllWithLastName(lastName);
        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "/{userId}/expenses", method = RequestMethod.GET)
    public ResponseEntity<List<Expense>> getAllExpenses(@PathVariable int userId) throws ExecutionException, InterruptedException {
        List<Expense> expenses = userService.getExpenses(userId);
        return ResponseEntity.ok(expenses);
    }

    @RequestMapping(value = "/{userId}/expenses", method = RequestMethod.POST)
    public ResponseEntity<Expense> addExpense(@PathVariable int userId,@RequestBody Expense expense)
            throws ExecutionException, InterruptedException {
        Expense expenseSaved = userService.addExpense(userId, expense);
        return ResponseEntity.ok(expenseSaved);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUser(@PathVariable int userId) {
        UserDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/{userId}/details", method = RequestMethod.GET)
    public ResponseEntity<UserExpensesDto> getAllUserDetail(@PathVariable int userId) {
        UserExpensesDto user = userService.getUserExpenseDetails(userId);
        return ResponseEntity.ok(user);
    }
}



