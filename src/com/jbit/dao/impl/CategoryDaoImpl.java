package com.jbit.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.jbit.dao.CategoryDao;
import com.jbit.entity.Category;
@Repository
public class CategoryDaoImpl extends BaseDaoHibernate implements CategoryDao{

	@Override
	public List<Category> findPageList(final Integer first,final Integer max) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Category>>() {
			@Override
			public List<Category> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=(Query) session.createQuery("from Category order by recommend desc");
				query.setFirstResult(first);
				query.setMaxResults(max);
				return query.list();
			}
		});
	};

	@Override
	public Object findCount() {
		return  super.getHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=(Query) session.createQuery("select count(*) from Category");
				return query.uniqueResult();
			}
		});
	}

	@Override
	public void insertCategory(Category category) {
		super.getHibernateTemplate().merge(category);
	};

	@Override
	public Category findById(Integer id) {
		return super.getHibernateTemplate().get(Category.class, id);
	}

	@Override
	public void updateCategory(Category category) {
		super.getHibernateTemplate().merge(category);
	}

	@Override
	public void deleteById(Integer id) {
		super.getHibernateTemplate().delete(super.getHibernateTemplate().get(Category.class, id));
	}

	@Override
	public List<Category> findAll() {
		return super.getHibernateTemplate().find("from Category");
	}
}
