package com.shopspecial.service;

import java.util.Collection;

import com.shopspecial.dao.ItemDAO;
import com.shopspecial.dao.ItemDAOImpl;
import com.shopspecial.pojo.Item;

public class ItemServiceImpl implements ItemService {

	private ItemDAO dao = new ItemDAOImpl();
	@Override
	public void addNewItem(Item item) {
		dao.addItem(item);
		
	}

	@Override
	public Collection<Item> viewAllItems() {
		return dao.viewAllItem();
		
	}

	@Override
	public Collection<Item> cartItems() {
			
			return dao.cartItem();
		}

	@Override
	public void delete(Item item1) {
		dao.delete(item1);
		
	}

	}



