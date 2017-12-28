package com.vendingDemo.model;

import java.util.Collections;
import java.util.List;import com.sun.org.apache.xalan.internal.xsltc.dom.CurrentNodeListIterator;
import com.vendingDemo.controller.Bucket;
import com.vendingDemo.controller.Item;
import com.vendingDemo.controller.coin;
import com.vendingDemo.view.Inventory;
import com.vendingDemo.view.ItemSoldOutException;
import com.vendingDemo.view.NotFullPaidException;
import com.vendingDemo.view.NotSufficientChangeException;

public class VendingMachineImplementation implements VendingMachine {

	//Define all instance variables 
	private Inventory<coin> coinInventory = new Inventory<>();
	private Inventory<Item> itemInventory = new Inventory<>();
	private long totalSales ;
	private long currentBal;
	private Item currentItem ; 
	
	
	public VendingMachineImplementation() {
		// TODO Auto-generated constructor stub
		initialize();
	}
	
	void initialize()
	{
		// initialize with 5 coins of each type and 5 of each item type. 
		for(coin c : coin.values())
			coinInventory.put(c, 5);
		for(Item i : Item.values())
			itemInventory.put(i, 5);
	}
	
	@Override
	public void insertCoin(coin coin) {
		// TODO Auto-generated method stub
		currentBal = currentBal + coin.getValue();
		coinInventory.add(coin);
		
	}

	@Override
	public long selectedItemAndGetPrice(Item item) {
		// TODO Auto-generated method stub
		if(itemInventory.hasItem(item))
		{
			currentItem = item; 
		}
		return currentItem.getPrice();
		
	}

	@Override
	public List<coin> refund() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bucket<Item, List<coin>> collectItemAndChange() {
		// TODO Auto-generated method stub
		Item item = collectItem();
		List<coin> changeCoin = collectCoin();
		Bucket<Item, List<coin>> change = new Bucket<Item, List<coin>>(item, changeCoin);
		return change;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
		coinInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        currentItem = null;
        currentBal = 0;
	}

	//Getting item form inventory 
	private Item collectItem() throws NotSufficientChangeException, NotFullPaidException{
      if(isFullPaid()){
    if(hasChange()){
        itemInventory.deduct(currentItem);
        return currentItem;
    }           
    throw new NotSufficientChangeException("Not Sufficient change in Inventory");
   
}
long remainingBalance = currentItem.getPrice() - currentBal;
throw new NotSufficientChangeException("Not Sufficient change in Inventory. Change your Product"); 
}

	public List<coin> collectCoin()
	{
		return null;
		
	}
	public boolean isFullPaid()
	{
		if(currentBal >= currentItem.getPrice())
		{
			return true;
		}
		return false; 
	}
	
	public boolean hasChange()
	{
		
	    return hasSufficientChange(currentBal - currentItem.getPrice());
	}
	
	public Boolean hasSufficientChange(long amount)
	{
		boolean hasChange= true; 
		try{
            getChange(amount);
        }catch(NotSufficientChangeException nsce){
            return hasChange = false;
        }
        return hasChange;
	}

	public List<coin> getChange(long amount)  throws NotSufficientChangeException
	{
		
		List<coin> changes = Collections.EMPTY_LIST;
		//to return denomination to get coin count 
		 
		while(amount >0)
		{
			if( amount >= coin.QUARTER.getValue() && coinInventory.hasItem(coin.QUARTER))
				{
				changes.add(coin.QUARTER);
				//update coin inventory quantity 
				amount =amount - coin.QUARTER.getValue();
				coinInventory.put(coin.QUARTER, coin.QUARTER.getValue()-1);
				continue;
				}
			else if(amount >= coin.NICKLE.getValue() && coinInventory.hasItem(coin.NICKLE))
			{
				changes.add(coin.NICKLE);
				amount =amount - coin.NICKLE.getValue();
				coinInventory.put(coin.NICKLE, coin.NICKLE.getValue()-1);
				continue;
			}
			else if(amount >= coin.DIME.getValue() && coinInventory.hasItem(coin.DIME))
			{
				changes.add(coin.DIME);
				amount =amount - coin.DIME.getValue();
				coinInventory.put(coin.DIME, coin.DIME.getValue()-1);
				continue;
			}
			else if(amount >= coin.PENNY.getValue() && coinInventory.hasItem(coin.PENNY))
			{
				changes.add(coin.PENNY);
				amount =amount - coin.PENNY.getValue();
				coinInventory.put(coin.PENNY, coin.PENNY.getValue()-1);
				continue;
			}
			else 
				{ throw new NotSufficientChangeException("Not sufficient change in the bank please try again with different product!"); }
		}
		
		return changes; 
	}
	
	
	
}
