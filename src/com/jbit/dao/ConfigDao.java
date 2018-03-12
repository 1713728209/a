package com.jbit.dao;

import java.util.List;

import com.jbit.entity.Config;

public interface ConfigDao {
	List<Config> findPageList(Integer first,Integer max);
	
	Integer findcount();
	
	void insertConfig(Integer id,String value);
	
	List<Config> findAll();
}
