package com.cvg.dao;

import java.util.List;

import com.cvg.model.Item;

public interface DAO {

	List<Item> getAllItems();

	Item getItemByID(int itemId);
	
	public void addItem(Item item);
	
	public void delete(Integer itemId);

}