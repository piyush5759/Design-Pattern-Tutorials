package com.vendingDemo.view;

public class ItemSoldOutException extends RuntimeException {

	
	private String msg;

	public ItemSoldOutException(String msg)  {
		super();
		this.msg = msg;
	}
	
	public String getMessage()
	{
		return msg; 
	}
}
