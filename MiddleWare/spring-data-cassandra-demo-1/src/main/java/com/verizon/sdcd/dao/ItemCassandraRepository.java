package com.verizon.sdcd.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.verizon.sdcd.model.Item;

public interface ItemCassandraRepository extends CassandraRepository<Item, Integer>{

}
