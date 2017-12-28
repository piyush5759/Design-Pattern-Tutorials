package com.vendingDemo.view;

public class NotFullPaidException extends RuntimeException {

	private String message;

	public NotFullPaidException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
}
