package com.aro.model;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ErrorModel {
	private Date timestamp;
	private String message;
	private int status;
	private String path;
	
	public ErrorModel(Date timestamp, String message, int status, String path) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.path = path;
	}
	 
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	//
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}
//
