package com.divya.ExpenseTracker.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.divya.ExpenseTracker.model.Expense;


@Repository("repo")
public interface ExpenseRepo extends JpaRepository<Expense, Integer> {
	List<Expense> findById(int id);
}
