package com.journaldev.spring.model;

import java.util.LinkedList;
import java.util.List;

public class ItemListContainer {

	public ItemListContainer(List<Item> list) {
		this.itemList=itemList;
	}

	private List<Item> itemList = new LinkedList<Item>();

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
}
