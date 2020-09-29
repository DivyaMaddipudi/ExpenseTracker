package com.divya.ExpenseTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.divya.ExpenseTracker.model.Expense;
import com.divya.ExpenseTracker.model.ExpenseTrackerModel;
import com.divya.ExpenseTracker.service.ExpenseService;

@Controller
public class HomeController {

	@Autowired
	private ExpenseTrackerModel expenseTracker;

	@Autowired
	private ExpenseService expenseService;

	
	@GetMapping("/")
	public String home() {
		return "index";
	}

//	@RequestMapping(value = "/addInitialAmount", method = RequestMethod.POST)
//	public String addInitialAmount(@RequestParam("basicAmount") String amount, Model model) {
//		int amt = Integer.parseInt(amount);
//		expenseTracker.setInitialAmount(amt);
//		expenseTracker.setMonthlyAmount(amt);
//		model.addAttribute("amount", amt);
//		return "addInitialAmount";
//	}

	@RequestMapping(value = "/addExpense", method = { RequestMethod.POST, RequestMethod.GET })
	public String addExpense(@ModelAttribute Expense exp, Model model) {
		if (exp.getAmount() != 0) {
			expenseService.saveItem(exp);
		}

		List<Expense> expList = expenseService.findAll();

		int income = expenseTracker.getIncome();
		int expense = expenseTracker.getExpense();
		int balance = 0;

		if (exp.getAmount() > 0) {
			expenseTracker.setInitialAmount(income);
			income += exp.getAmount();
			expenseTracker.setIncome(income);

			
			balance = exp.getAmount() + expenseTracker.getInitialAmount();
			expenseTracker.setInitialAmount(balance);

		} else if (exp.getAmount() < 0) {
			if (expenseTracker.getInitialAmount() + exp.getAmount() >= 0) {
				expense += exp.getAmount();
				expenseTracker.setExpense(expense);

				balance = expenseTracker.getInitialAmount() + exp.getAmount();
				expenseTracker.setInitialAmount(balance);

			} else {
				return "error";
			}
		} else {
			model.addAttribute("incomeVal", income);
			model.addAttribute("expense", expense);
			return "addInitialAmount";
		}

		model.addAttribute("amount", balance);
		model.addAttribute("incomeVal", income);
		model.addAttribute("expense", expense);
		model.addAttribute("expList", expList);

		return "index";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String deleteItem(@PathVariable("id") int id, Model model) {

		List<Expense> expIdList = expenseService.findById(id);
		
	
		int expenseAmount = expIdList.get(expIdList.size() - 1).getAmount();
		expIdList.clear();
		expenseService.deleteItem(id);
		List<Expense> expList = expenseService.findAll();
		
		int income = expenseTracker.getIncome();
		int expense = expenseTracker.getExpense();
		int balance =  0;
		if (expenseAmount > 0) {
			income = expenseTracker.getIncome() - expenseAmount;
			expenseTracker.setIncome(income);

		} else {
			expense = expenseTracker.getExpense() - expenseAmount;
			expenseTracker.setExpense(expense);
		}
		
		balance = expenseTracker.getIncome() + expenseTracker.getExpense();
		expenseTracker.setInitialAmount(balance);
		model.addAttribute("amount", balance);
		model.addAttribute("incomeVal", income);
		model.addAttribute("expense", expense);
		model.addAttribute("expList", expList);
		return "index";
	}
}