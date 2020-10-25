package com.amigo.addressservice.exception;

public class CountryNotFound extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public CountryNotFound() {
		this("City not found");
	}

	public CountryNotFound(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}
}
