package com.jbit.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.jbit.dao.CommentDao;
import com.jbit.entity.Comment;
@Repository
public class CommentDaoImpl extends BaseDaoHibernate implements CommentDao {

	@Override
	public Integer findCommentByPid(final Integer pid) {
		return super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery("select count(*) from Comment where product.id=?");
				query.setParameter(0, pid);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}

	@Override
	public void insertComment(Comment comment) {
		super.getHibernateTemplate().save(comment);
	}

	@Override
	public List<Comment> findPageList(final Integer first, final Integer max, final Integer pid) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Comment>>() {
			@Override
			public List<Comment> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery("from Comment where product.id=?");
				query.setParameter(0, pid);
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
				Query query=session.createQuery("select count(*) from Comment where product.id=?");
				query.setParameter(0, pid);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}

}
