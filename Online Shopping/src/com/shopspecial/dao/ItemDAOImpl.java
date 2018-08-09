package com.shopspecial.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.shopspecial.pojo.Item;

public class ItemDAOImpl implements ItemDAO{

	private Map<Integer, Item> itemDB = new HashMap<>();
	private Map<Integer, Item> cartDB = new HashMap<>();
	@Override
	public void addItem(Item item) {
		cartDB.put(item.getId(), item);
		
	}

	@Override
	public Collection<Item> cartItem() {
		return cartDB.values();
	}

	@Override
	public Collection<Item> viewAllItem() {
	
		itemDB.put(1,new Item(1,"ECO Bottle","Red Colour- Tupperware", 400.0));
		itemDB.put(2,new Item(2,"One Plus 5","Android 8.0 - Dual Camera", 40000.0));
	    itemDB.put(3,new Item(3,"JBL Headphones","Black Colour- 13hours Battery Life", 3000));
	    itemDB.put(4,new Item(4,"CAT Watch","Colour: Black And Yellow",8000));
	    itemDB.put(5,new Item(5,"Ray-Ban","Brown Colour- Full Frame", 5000));
	    itemDB.put(6,new Item(6,"USPA Shirt","Blue Colour- Full Sleeves", 3000));
	
	    return itemDB.values();
	}

	@Override
	public void delete(Item item1) {
		cartDB.remove(item1.getId());

		
	}

}
