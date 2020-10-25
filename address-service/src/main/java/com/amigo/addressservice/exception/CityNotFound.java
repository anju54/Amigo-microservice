package com.amigo.addressservice.exception;

public class CityNotFound extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public CityNotFound() {
		this("City not found");
	}

	public CityNotFound(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}
}
