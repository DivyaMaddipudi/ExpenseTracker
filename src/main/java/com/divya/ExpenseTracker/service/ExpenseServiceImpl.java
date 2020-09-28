package com.divya.ExpenseTracker.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divya.ExpenseTracker.model.Expense;
import com.divya.ExpenseTracker.repo.ExpenseRepo;

@Transactional
@Service
public class ExpenseServiceImpl implements ExpenseService{
	
	@Autowired
	private ExpenseRepo repo;
	
	@Override
	public List<Expense> findAll() {
		return repo.findAll();
	}
	
	@Override
	public void saveItem(Expense exp) {
		repo.save(exp);
		
	}

	@Override
	public void deleteItem(int id) {
		repo.deleteById(id);
	}

	@Override
	public List<Expense> findById(int id) {
		return repo.findById(id);
	}

}
