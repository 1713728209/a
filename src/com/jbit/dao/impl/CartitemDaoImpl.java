package com.jbit.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.jbit.dao.CartitemDao;
import com.jbit.entity.Cartitem;
@Repository
public class CartitemDaoImpl extends BaseDaoHibernate implements CartitemDao{

	@Override
	public Integer findProduct(final Integer uid) {
		return super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery("SELECT count(*) FROM Cartitem WHERE uid=?");
				query.setParameter(0, uid);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}

	@Override
	public List<Cartitem> findPageList(final Integer first, final Integer max, final Integer uid) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Cartitem>>() {
			@Override
			public List<Cartitem> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery("FROM Cartitem where user.id =?");
				query.setParameter(0, uid);
				query.setFirstResult(first);
				query.setMaxResults(max);
				return query.list();
			}
		});
	}

	@Override
	public Integer findCount(final Integer uid) {
		return super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery("select count(*) FROM Cartitem where user.id =?");
				query.setParameter(0, uid);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}

	@Override
	public void deleteById(Integer id) {
		super.getHibernateTemplate().delete(super.getHibernateTemplate().get(Cartitem.class, id));
	}

	
}
