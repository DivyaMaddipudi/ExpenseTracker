package com.divya.ExpenseTracker.service;

import java.util.List;

import com.divya.ExpenseTracker.model.Expense;

public interface ExpenseService {
	
	public List<Expense> findAll();

	public void saveItem(Expense exp);

	public void deleteItem(int id);

	public List<Expense> findById(int id);

}
