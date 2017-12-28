package com.vendingDemo.view;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
	
	private Map<T, Integer> inventory = new HashMap<T, Integer>();
    
	public int getQuantity(T item){
		Integer val = inventory.get(item);
		return val ==  null ?0 : val;	
	}
	
	public void add(T item)
	{
	  inventory.put(item, inventory.get(item) + 1);
	}
	
	public void deduct(T item)
	{
		 if( hasItem(item) )
		 inventory.put(item, inventory.get(item) - 1);
	}
	
	public void clear()
	{
		inventory.clear();
	}
	
	public boolean hasItem(T item)
	{
		// check it has item or not. 
		return getQuantity(item)>0; 
	}
	public void put(T item , int quantity)
	{
		inventory.put(item, quantity);
	}
}