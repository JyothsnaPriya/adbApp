package com.verizon.sjdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.verizon.sjdbc.exception.CustomExceptionTranslator;
import com.verizon.sjdbc.model.Item;

@Repository
public class ItemDAOImp1 implements ItemDAO {
	private JdbcTemplate jtmp;
	
	@Autowired
	private ItemRowMapper rowMapper;

	public ItemDAOImp1(DataSource ds,CustomExceptionTranslator expt) {
		this.jtmp = new JdbcTemplate(ds);
		jtmp.setExceptionTranslator(expt);
	}

	@Override
	public void addItem(Item item) {

		jtmp.update(IQueryMapper.INS_ITEM_QRY,
				item.getiCode(),
				item.getiName(),
				item.getiPrice());

	}

	@Override
	public void removeItem(int iCode) {
		jtmp.update(IQueryMapper.DEL_ITEM_QRY,iCode);

	}

	@Override
	public void updatIetem(Item item) {
		jtmp.update(IQueryMapper.UPD_ITEM_QRY,
				item.getiName(),
				item.getiPrice(),
				item.getiCode());	

	}

	@Override
	public Item getItem(int iCode) {
		List<Item> items=
				jtmp.query(IQueryMapper.GET_ITEM_QRY,
						new Object[] {iCode},
						rowMapper);
		return items!=null && items.size()>0?items.get(0):null;
	}

	@Override
	public List<Item> getItems() {
			return jtmp.query(IQueryMapper.GET_ALL_ITEMS_QRY,
					rowMapper);
	}

}
