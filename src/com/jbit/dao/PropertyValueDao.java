package com.jbit.dao;

import java.util.List;

import com.jbit.entity.PropertyValue;

public interface PropertyValueDao {
	List<PropertyValue> findPageList(Integer first,Integer max,Integer pid);
	
	Object findcount(Integer pid);
	
	Integer updatePropertyValue(Integer id,String str);
}
