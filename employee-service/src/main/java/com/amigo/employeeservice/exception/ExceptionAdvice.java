package com.amigo.employeeservice.exception;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amigo.employeeservice.dto.UserErrorDto;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<UserErrorDto> mapExceptionEntityNotFound(EntityNotFound enf){
		
		UserErrorDto userErr = new UserErrorDto(HttpStatus.SC_CONFLICT,enf.getMessage());
		
		return new ResponseEntity<UserErrorDto>(userErr, org.springframework.http.HttpStatus.CONFLICT );
	}

}
