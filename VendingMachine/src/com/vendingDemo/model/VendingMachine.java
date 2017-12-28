package com.vendingDemo.model;

import java.util.List;

import com.vendingDemo.controller.Bucket;
import com.vendingDemo.controller.Item;
import com.vendingDemo.controller.coin;

public interface VendingMachine {

	public void insertCoin(coin coin);
	public long selectedItemAndGetPrice(Item item);
	public List<coin> refund();
	public Bucket<Item, List<coin>> collectItemAndChange(); 
	public void reset();
}
