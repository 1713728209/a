package com.jbit.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.jbit.dao.PropertyValueDao;
import com.jbit.entity.PropertyValue;
@Repository
public class PropertyValueDaoImpl extends BaseDaoHibernate implements PropertyValueDao {

	@Override
	public List<PropertyValue> findPageList(final Integer first, final Integer max, final Integer pid) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<PropertyValue>>() {
			@Override
			public List<PropertyValue> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery("from PropertyValue where product.id=? and property.category.id=product.category.id");
				query.setParameter(0, pid);
				query.setFirstResult(first);
				query.setMaxResults(max);
				return query.list();
			}
		});
	}

	@Override
	public Object findcount(final Integer pid) {
		return super.getHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery("select count(*) from PropertyValue where product.id=? and property.category.id=product.category.id");
				query.setParameter(0, pid);
				return query.uniqueResult();
			}
		});
	}

	@Override
	public Integer updatePropertyValue(Integer id,String str) {
		return super.getHibernateTemplate().bulkUpdate("update PropertyValue set value=? where id=?",str,id);
	}

}
