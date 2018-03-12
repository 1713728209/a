package com.jbit.dao;

import java.util.List;

import com.jbit.entity.Property;

public interface PropertyDao {
	
	List<Property> findPageList(Integer first,Integer max,Integer cid);
	
	Object findcount(Integer cid);
	
	void updateProperty(Property property);
	
	void deleteProperty(Integer id);
	
	Property findById(Integer id);

}
