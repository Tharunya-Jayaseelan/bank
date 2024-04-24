package com.tharun.Bank_application.customException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tharun.Bank_application.entity.ErrorResponse;

@ControllerAdvice
@ResponseStatus
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorResponse> noSuchElementException(NoSuchElementException exception, WebRequest reques)
	{
		ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(AccountAlredyExistsException.class)
	public ResponseEntity<ErrorResponse> accountAlreadyExistsException(AccountAlredyExistsException exception,WebRequest request)
	{
		ErrorResponse response = new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		
	}
}
