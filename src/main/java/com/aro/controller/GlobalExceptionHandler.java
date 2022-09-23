package com.aro.controller;

import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.aro.exception.AppointmentNotFoundException;
import com.aro.exception.DoctorNotFoundException;
import com.aro.exception.DuplicateDoctortDetailslException;
import com.aro.exception.DuplicatePatientDetailslException;
import com.aro.exception.PatientNotFoundException;
import com.aro.model.ErrorModel;
import org.springframework.validation.FieldError;

import java.util.Collection;
import org.springframework.http.HttpStatus;
@RestControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
			Map<String, String> errors = new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach((error) ->{
				
				String fieldName = ((FieldError) error).getField();
				String message = error.getDefaultMessage();
				errors.put(fieldName, message);
			});
	        
	        
	        return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	    }
	

	//patient
	@ExceptionHandler(DuplicatePatientDetailslException.class)
	public ResponseEntity<ErrorModel> handleDuplicatePatientDetailsFoundException(DuplicatePatientDetailslException ex, WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.CONFLICT.value(),req.getDescription(false));
		
		
		
		return new ResponseEntity<ErrorModel>(model,HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ErrorModel> handleDuplicatePatientDetailsFoundException(PatientNotFoundException ex, WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.NOT_FOUND.value(),req.getDescription(false));
		return new ResponseEntity<ErrorModel>(model,HttpStatus.NOT_FOUND);
		
	}
	
	//doctor
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<ErrorModel> handleDuplicateDoctorNotFoundException(DoctorNotFoundException ex, WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.NOT_FOUND.value(),req.getDescription(false));
		
		return new ResponseEntity<ErrorModel>(model,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(DuplicateDoctortDetailslException.class)
	public ResponseEntity<ErrorModel> handleDuplicateDoctorDetailsFoundException(DuplicateDoctortDetailslException ex, WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.CONFLICT.value(),req.getDescription(false));
		
		return new ResponseEntity<ErrorModel>(model,HttpStatus.CONFLICT);
		
	}

	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<ErrorModel> handleDuplicateAppointmentDetailsFoundException(AppointmentNotFoundException ex, WebRequest req)
	{
		ErrorModel model = new ErrorModel(new Date(), ex.getMessage(),HttpStatus.NOT_FOUND.value(),req.getDescription(false));
		return new ResponseEntity<ErrorModel>(model,HttpStatus.NOT_FOUND);
		
	}
	

}
//
