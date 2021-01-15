package com.amigo.employeeservice.exception;

public class EntityNotFound extends Exception{

private static final long serialVersionUID = 1L;
	
	private String message;

	public EntityNotFound(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
