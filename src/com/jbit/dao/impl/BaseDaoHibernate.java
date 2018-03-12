package com.jbit.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoHibernate extends HibernateDaoSupport{
	@Resource
	public void sessionFactory2(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
}
