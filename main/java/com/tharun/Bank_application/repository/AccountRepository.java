package com.tharun.Bank_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tharun.Bank_application.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	@Query(value="select balance from accounts a where a.id=?1",nativeQuery = true)
	public double getBalanceById(long id);

}
