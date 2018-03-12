package com.jbit.dao;

import com.jbit.entity.Orderitem;

public interface OrderitemDao {
	Orderitem findOrderitemByOid(Integer oid);
	
	void insertOrderitem(Orderitem orderitem);
}
