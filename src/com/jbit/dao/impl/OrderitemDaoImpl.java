package com.jbit.dao.impl;

import org.springframework.stereotype.Repository;

import com.jbit.dao.OrderitemDao;
import com.jbit.entity.Orderitem;
@Repository
public class OrderitemDaoImpl extends BaseDaoHibernate implements OrderitemDao {

	@Override
	public Orderitem findOrderitemByOid(Integer oid) {
		return (Orderitem) super.getHibernateTemplate().find("from Orderitem where order.id=?",oid).get(0);
	}

	@Override
	public void insertOrderitem(Orderitem orderitem) {
		 super.getHibernateTemplate().save(orderitem);
	}

}
