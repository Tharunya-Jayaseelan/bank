package com.tharun.Bank_application.service;

import java.util.List;

import com.tharun.Bank_application.entity.Logger;

public interface LoggerService {
	
	void createLog(Logger logger);
	List<Logger> showLogsByAccount_no(long id);
	List<Logger> ShowAllLogs();
	

}
