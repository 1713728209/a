package com.jbit.dao;

import java.util.List;

import com.jbit.entity.Cartitem;

public interface CartitemDao {
	Integer findProduct(Integer uid);
	
	 List<Cartitem> findPageList(Integer first,Integer max,Integer uid);
		
	Integer findCount(Integer uid);
	
	void deleteById(Integer id);
}
