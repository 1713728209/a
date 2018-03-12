package com.jbit.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.jbit.dao.ProductImageDao;
import com.jbit.entity.ProductImage;

@Repository
public class ProductImageDaoImpl extends BaseDaoHibernate implements ProductImageDao{

	@Override
	public List<ProductImage> findPageList(final Integer first, final Integer max, final Integer pid) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<ProductImage>>() {
			@Override
			public List<ProductImage> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery("from ProductImage where product.id=? order by id asc");
				query.setParameter(0,pid);
				query.setFirstResult(first);
				query.setMaxResults(max);
				return query.list();
			}
		});
	}

	@Override
	public Integer findcount(final Integer pid) {
		return super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery("select count(*) from ProductImage where product.id=?");
				query.setParameter(0, pid);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
}
