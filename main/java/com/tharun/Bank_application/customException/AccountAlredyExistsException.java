package com.tharun.Bank_application.customException;

public class AccountAlredyExistsException extends RuntimeException{
	
	private String message;

	public AccountAlredyExistsException() {
		super();
	}

	public AccountAlredyExistsException(String message) {
		super(message);
		this.message = message;
	}
	
	

}
