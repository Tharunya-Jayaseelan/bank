package com.tharun.Bank_application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tharun.Bank_application.entity.Logger;

public interface LoggerRepository extends JpaRepository<Logger, Long>   {
	
	@Query(value="select * from Logs l where l.account_no=?1",nativeQuery = true)
	public List<Logger> findByAccount_no(long account_no);
	
	

}
