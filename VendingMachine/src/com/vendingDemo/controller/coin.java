package com.vendingDemo.controller;

/*
 * This is to manage coin denomination that vending would be supporting. 
 */
public enum coin {

	PENNY(1), NICKLE(5) , DIME(10), QUARTER(25);
	
	private int value;
	
	private coin(int value)
	{
		this.value=value;
	}
	
	public int getValue(){
		return value;
	}
	
}
