package com.tharun.Bank_application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tharun.Bank_application.customException.AccountAlredyExistsException;
import com.tharun.Bank_application.customException.NoSuchElementException;
import com.tharun.Bank_application.entity.Account;
import com.tharun.Bank_application.entity.Logger;
import com.tharun.Bank_application.repository.AccountRepository;
import com.tharun.Bank_application.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;



	@Override
	public String createAccount(Account account) {
		Account existingAccount=accountRepository.findById(account.getId()).orElse(null);
		if(existingAccount==null)
		{
		  accountRepository.save(account);
		  return "Account created sucessfully";
		}
		else
		    throw new AccountAlredyExistsException("This Account already exists");
	}

	@Override
	public Account getById(long id) {
		return accountRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Account does not exists"));
	}

	@Override
	public Account deposit(long id, double amount) {
		Account account=accountRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Account does not exists"));
		double total=account.getBalance()+amount;
		account.setBalance(total);
		return accountRepository.save(account);
	}

	@Override
	public Account withdraw(long id, double amount) {
		Account account=accountRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Account does not exists"));
		if(account.getBalance() < amount)
		{
			throw new RuntimeException("Insufficient balance");
		}
		double total=account.getBalance() - amount;
		account.setBalance(total);
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts=accountRepository.findAll();
		return accounts;
	}

	@Override
	public String delete(long id) {
		Account account=accountRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Account does not exists"));
		accountRepository.delete(account);

		return "Account deleted successfully";
	}

	@Override
	public double getbalance(long id) {
		
		return accountRepository.getBalanceById(id);
		
	}

	
}