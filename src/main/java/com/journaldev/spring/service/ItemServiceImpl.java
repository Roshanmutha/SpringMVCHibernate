package com.journaldev.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ItemDAO;
import com.journaldev.spring.model.Item;
import com.journaldev.spring.model.Item;

public class ItemServiceImpl implements ItemService {
	
	private ItemDAO itemDAO;

	public void setItemDAO(ItemDAO ItemDAO) {
		this.itemDAO = ItemDAO;
	}

	@Override
	@Transactional
	public void addItem(Item p) {
		this.itemDAO.addItem(p);
	}

	@Override
	@Transactional
	public void updateItem(Item p) {
		this.itemDAO.updateItem(p);
	}

	@Override
	@Transactional
	public List<Item> listItems() {
		return this.itemDAO.listItems();
	}

	@Override
	@Transactional
	public Item getItemById(int id) {
		return this.itemDAO.getItemById(id);
	}

	@Override
	@Transactional
	public void removeItem(int id) {
		this.itemDAO.removeItem(id);
	}

}
