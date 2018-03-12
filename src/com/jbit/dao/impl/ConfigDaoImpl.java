package com.jbit.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.jbit.dao.ConfigDao;
import com.jbit.entity.Config;
@Repository
public class ConfigDaoImpl extends BaseDaoHibernate implements ConfigDao {

	@Override
	public List<Config> findPageList(final Integer first, final Integer max) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Config> >() {
			@Override
			public List<Config>  doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=(Query) session.createQuery("from Config order by id asc");
				query.setFirstResult(first);
				query.setMaxResults(max);
				return query.list();
			}
		});
	}

	@Override
	public Integer findcount() {
		return super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer  doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=(Query) session.createQuery("select count(*) from Config");
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}

	@Override
	public void insertConfig(Integer id,String value) {
		super.getHibernateTemplate().bulkUpdate("update Config set value=? where id=?",value,id);
	}

	@Override
	public List<Config> findAll() {
		return super.getHibernateTemplate().find("from Config");
	}
}
