package com.verizon.sdmd.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.verizon.sdmd.model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void addItem(Item item) {
		mongoTemplate.insert(item);

	}

	@Override
	public void removeItem(int iCode) {
		mongoTemplate.remove(getItem(iCode));

	}

	@Override
	public void updateItem(Item item) {
		mongoTemplate.save(item);

	}

	@Override
	public Item getItem(int iCode) {
		return mongoTemplate.findById(iCode, Item.class);
		
	}

	@Override
	public List<Item> getItems() {
		return mongoTemplate.findAll(Item.class);
	}

}
