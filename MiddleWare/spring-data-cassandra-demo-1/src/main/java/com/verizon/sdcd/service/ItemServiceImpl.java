package com.verizon.sdcd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sdcd.dao.ItemCassandraRepository;
import com.verizon.sdcd.model.Item;


@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemCassandraRepository itemDAO;

	@Override
	public void addItem(Item item) {
		itemDAO.insert(item);

	}

	@Override
	public void removeItem(int iCode) {
		itemDAO.deleteById(iCode);

	}

	@Override
	public void updateItem(Item item) {
		itemDAO.save(item);

	}

	@Override
	public Item getItem(int iCode) {
		Optional<Item> opt = itemDAO.findById(iCode);
		return opt.isPresent()?opt.get():null;
	}

	@Override
	public List<Item> getItems() {
		
		return itemDAO.findAll();
	}

	@Override
	public boolean exists(int iCode) {
	
		return itemDAO.existsById(iCode);
	}


}
