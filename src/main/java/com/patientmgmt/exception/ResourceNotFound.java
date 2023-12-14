package com.patientmgmt.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends Exception{
	 
	public ResourceNotFound(String message) {
 
		super(message);
 
	}
}

