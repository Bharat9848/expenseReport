package com.bharat.user.repo;

import com.bharat.user.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by BharatBh on 2/20/2017.
 */
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
