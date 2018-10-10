package com.verizon.sjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sjdbc.dao.ItemDAO;
import com.verizon.sjdbc.model.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDAO itemDAO;

	@Override
	public void addItem(Item item) {
		itemDAO.addItem(item);

	}

	@Override
	public void removeItem(int iCode) {
		itemDAO.removeItem(iCode);

	}

	@Override
	public void updateItem(Item item) {
		itemDAO.updateItem(item);

	}

	@Override
	public Item getItem(int iCode) {
		
		return itemDAO.getItem(iCode);
	}

	@Override
	public List<Item> getItems() {
		
		return itemDAO.getItems();
	}

	@Override
	public boolean exists(int iCode) {
	
		return itemDAO.getItem(iCode)!=null;
	}

}
