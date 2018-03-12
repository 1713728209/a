package com.jbit.dao;

import java.util.List;

import com.jbit.entity.Category;

public interface CategoryDao {

    List<Category> findPageList(Integer first,Integer max);
	
	Object findCount();
	
	void insertCategory(Category category);
	
	Category findById(Integer id);
	
	void updateCategory(Category category);
	
	void deleteById(Integer id);
	
	List<Category> findAll();
}
