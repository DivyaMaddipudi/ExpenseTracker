package com.divya.ExpenseTracker.model;

import org.springframework.stereotype.Component;

@Component
public class ExpenseTrackerModel {
	
	private int initialAmount = 0;
	
	private int monthlyAmount = 0;
	private int expense = 0;
	private int income = 0;

	public int getInitialAmount() {
		return initialAmount;
	}

	public void setInitialAmount(int initialAmount) {
		this.initialAmount = initialAmount;
	}

	public int getExpense() {
		return expense;
	}

	public void setExpense(int expense) {
		this.expense = expense;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getMonthlyAmount() {
		return monthlyAmount;
	}

	public void setMonthlyAmount(int monthlyAmount) {
		this.monthlyAmount = monthlyAmount;
	}
}