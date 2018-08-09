package com.shopspecial.dao;

import java.util.Collection;

import com.shopspecial.pojo.Item;

public interface ItemDAO {

	void addItem(Item item);

    Collection<Item> cartItem();
	
	Collection<Item> viewAllItem();

	void delete(Item item1);

	
}
