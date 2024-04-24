package com.tharun.Bank_application.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tharun.Bank_application.entity.Account;
import com.tharun.Bank_application.entity.Logger;
import com.tharun.Bank_application.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private LogController logCon;
	
	
	
	
	@GetMapping("/account/{id}")
	public Account getAccountDetails(@PathVariable int id)
	{
			return accountService.getById(id);
	}

	@PostMapping("/account")
	public ResponseEntity<String> createAccount(@RequestBody Account account)
	{
		return new ResponseEntity<String>(accountService.createAccount(account), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/deposit/{accNo}")
	public Account depositAmount(@PathVariable long
			accNo, @RequestBody Map<String, Double> request) {
		double amount=request.get("amount");
		double initBalance=accountService.getbalance(accNo);
		Account account=accountService.deposit(accNo, amount);
		logCon.addLog(new Logger(account.getId(),"Success","Deposit",initBalance,initBalance+amount));
		return account;
	}
	
	@PutMapping("/withdraw/{accNo}")
	public Account withdrawAmount(@PathVariable long accNo, @RequestBody Map<String, Double> request) {
		double amount=request.get("amount");
		double initBalance=accountService.getbalance(accNo);
		Account account=accountService.withdraw(accNo, amount);
		logCon.addLog(new Logger(account.getId(),"success","Withdraw",initBalance,initBalance-amount));
		return account;
	}
	
	@GetMapping("/balance/{id}")
	public double showBalance(@PathVariable int id) {
		return accountService.getbalance(id);
	
	}
	@GetMapping("/accounts")
	public List<Account> getAllAccounts()
	{
		return accountService.getAllAccounts();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>  deleteAccount(@PathVariable int id)
	{
		
		return ResponseEntity.ok().header("delete message", "account deleted").body(accountService.delete(id));
	}

}