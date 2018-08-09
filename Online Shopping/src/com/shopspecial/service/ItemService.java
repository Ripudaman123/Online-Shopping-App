package com.shopspecial.service;

import java.util.Collection;

import com.shopspecial.pojo.Item;

public interface ItemService {

	void addNewItem(Item item);
	
	Collection<Item> cartItems();
	
	Collection<Item> viewAllItems();

	void delete(Item item1);
}
