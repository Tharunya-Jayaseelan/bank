package com.tharun.Bank_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tharun.Bank_application.entity.Logger;
import com.tharun.Bank_application.service.LoggerService;

@RestController
public class LogController {
	
	@Autowired
	private LoggerService loggerService;
	
	public void addLog(Logger logger)
	{
		loggerService.createLog(logger);
	}
	
	@GetMapping("/showLogs/{account_no}")
	public List<Logger> getLogsByAccount_no(@PathVariable long account_no)
	{
		return loggerService.showLogsByAccount_no(account_no);
		
	}
	
	@GetMapping("/showLogs")
	public List<Logger> getAllLogs()
	{
		return loggerService.ShowAllLogs();
		
	}

}
