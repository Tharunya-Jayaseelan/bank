package com.tharun.Bank_application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tharun.Bank_application.entity.Logger;
import com.tharun.Bank_application.repository.LoggerRepository;
import com.tharun.Bank_application.service.LoggerService;

@Service
public class LoggerServiceImpl implements LoggerService{
	
	@Autowired
	private LoggerRepository logrepo;
	

	@Override
	public void createLog(Logger logger) {
		logrepo.save(logger);
		
	}

	
	@Override
	public List<Logger> showLogsByAccount_no(long account_no) {
		List<Logger> logs=logrepo.findByAccount_no(account_no);
		return logs;
	}

	@Override
	public List<Logger> ShowAllLogs() {
		List<Logger> logs=logrepo.findAll();
		return logs;
	}
	
	

}
