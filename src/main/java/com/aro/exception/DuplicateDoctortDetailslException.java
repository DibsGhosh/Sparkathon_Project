package com.aro.exception;

import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateDoctortDetailslException extends RuntimeException {

	public DuplicateDoctortDetailslException(String message) {
		super(message);
		
	}
	
	

}
//