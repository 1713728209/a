package com.jbit.dao;

import java.util.List;

import com.jbit.entity.User;

public interface UserDao {
	User findLogin(User user);
	
	List<User> findPageList(Integer first,Integer max);
	
	Object findCount();
	
	List<User> findAll();
	
	void insertUser(User user);
}
