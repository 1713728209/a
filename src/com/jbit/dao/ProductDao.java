package com.jbit.dao;

import java.util.List;

import com.jbit.entity.Product;

public interface ProductDao {
	List<Product> fidnPageList(Integer first,Integer max,Integer cid,String keyword);
	
	Integer findCount(Integer cid,String keyword);
	
	Product findById(Integer id);
	
	void deleteById(Integer id);
	
	void updateProduct(Product product);
	
	Integer findCommentCountById(Integer id);
	
	Integer updateProduct2(Product product);
	
	void insertProduct(Product product);
}
