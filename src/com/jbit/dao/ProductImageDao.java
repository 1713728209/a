package com.jbit.dao;

import java.util.List;

import com.jbit.entity.ProductImage;

public interface ProductImageDao {
	List<ProductImage> findPageList(Integer first,Integer max,Integer pid);
	
	Integer findcount(Integer pid);
}
