package com.divya.ExpenseTracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divya.ExpenseTracker.model.Expense;

public interface ExpenseRepo extends JpaRepository<Expense, Integer> {

}
