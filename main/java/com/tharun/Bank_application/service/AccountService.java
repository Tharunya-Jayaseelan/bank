package com.tharun.Bank_application.service;

import java.util.List;

import com.tharun.Bank_application.entity.Account;
import com.tharun.Bank_application.entity.Logger;

public interface AccountService {
	
   String createAccount(Account account);
   Account getById(long id);
   Account deposit(long id, double amount);
   Account withdraw(long id, double amount);
   List<Account> getAllAccounts();
   String delete(long id);
   double getbalance(long id);
}
