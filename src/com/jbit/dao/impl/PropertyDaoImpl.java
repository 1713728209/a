package com.jbit.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.jbit.dao.PropertyDao;
import com.jbit.entity.Property;
@Repository
public class PropertyDaoImpl extends BaseDaoHibernate implements PropertyDao {

	@Override
	public List<Property> findPageList(final Integer first,final Integer max,final Integer cid) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Property>>() {

			@Override
			public List<Property> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery("from Property where cid=?");
				query.setFirstResult(first);
				query.setMaxResults(max);
				query.setParameter(0, cid);
				return (List<Property>)query.list();
			}
		});
	}

	@Override
	public Object findcount(final Integer cid) {
		return super.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery("select count(*) from Property where cid=?");
				query.setParameter(0, cid);
				return query.uniqueResult();
			}
		});
	}

	@Override
	public void updateProperty(Property property) {
		super.getHibernateTemplate().merge(property);
	}

	@Override
	public void deleteProperty(Integer id) {
		super.getHibernateTemplate().delete(super.getHibernateTemplate().get(Property.class, id));
	}

	@Override
	public Property findById(Integer id) {
		return super.getHibernateTemplate().get(Property.class, id);
	}
}
