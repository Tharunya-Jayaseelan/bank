package com.tharun.Bank_application.customException;

public class NoSuchElementException extends RuntimeException{
	
	private String message;
	
	

	public NoSuchElementException() {
		super();
	}



	public NoSuchElementException(String message) {
		super(message);
		this.message = message;
	}
	

}
