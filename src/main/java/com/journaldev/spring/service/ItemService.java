package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Item;

public interface ItemService {



	public void addItem(Item p);
	public void updateItem(Item p);
	public List<Item> listItems();
	public Item getItemById(int id);
	public void removeItem(int id);
	

}
