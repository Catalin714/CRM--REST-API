package com.selflearning.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	
	//Add an exception handler for CustomerNotFoundException
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {
		
		
			
			// create a CustomerErrorResponse
			
		    CustomerErrorResponse errorResponse = new CustomerErrorResponse();
			errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
			errorResponse.setMessage(exc.getMessage());
			errorResponse.setTimeStamp(System.currentTimeMillis());
			
			
		
			// return ResponseEntity
			
			return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
		
	}
	
	
	
	
	//Add another exception handler.... to catch any exception( catch all)
	
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc) {
		CustomerErrorResponse errorResponse = new CustomerErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
	    errorResponse.setMessage(exc.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	
	}

}