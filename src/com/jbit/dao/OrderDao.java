package com.jbit.dao;

import java.util.List;

import com.jbit.entity.Order;

public interface OrderDao {
	List<Order> findPageList(Integer first,Integer max,Integer uid,String address);
	
	Integer findcount(Integer uid,String address);
	
	Integer updateStatus(Integer id);
	
	Integer updateStatus2(Integer oid);
	Integer updateStatus3(Integer oid);

	List<Order> findAll();
	
	Order findOrderById(Integer oid);
}
