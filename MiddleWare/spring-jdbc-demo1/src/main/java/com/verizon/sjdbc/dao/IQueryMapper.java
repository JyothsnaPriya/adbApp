package com.verizon.sjdbc.dao;

public interface IQueryMapper {
	public static final String INS_ITEM_QRY=
		"INSERT INTO Items VALUES(?,?,?)";
	public static final String UPD_ITEM_QRY=
		"UPDATE items SET iname=?,iprice=? WHERE icode=?";
	public static final String DEL_ITEM_QRY=
		"DELETE FROM Items WHERE icode=?";
	public static final String GET_ITEM_QRY=
		"SELECT * from Items WHERE icode=?";
	public static final String GET_ALL_ITEMS_QRY=
		"SELECT * FROM Items";

}
