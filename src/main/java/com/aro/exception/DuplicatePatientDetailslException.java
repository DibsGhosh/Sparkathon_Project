package com.aro.exception;

import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicatePatientDetailslException extends RuntimeException {

	public DuplicatePatientDetailslException(String message) {
		super(message);
		
	}
	
	

}
//