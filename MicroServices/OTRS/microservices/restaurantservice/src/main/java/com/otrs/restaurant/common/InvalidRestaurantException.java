package com.otrs.restaurant.common;

public class InvalidRestaurantException extends Exception {

	private static final long serialVersionUID = 8890080495441147845L;
	
	private String message;
	private Object[] args;
	
	public InvalidRestaurantException(String message, Object[] args) {
		super();
		this.message = message;
		this.args = args;
	}

	public InvalidRestaurantException(String message) {
		this.message = String.format("%s is an invalid restaurant.", message);
	}
	
	public InvalidRestaurantException(Object[] args) {
		this.args = args;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}
	
	

}
