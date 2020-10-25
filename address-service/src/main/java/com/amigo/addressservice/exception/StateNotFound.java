package com.amigo.addressservice.exception;

public class StateNotFound extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public StateNotFound() {
		this("City not found");
	}

	public StateNotFound(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}
}
