package com.jbit.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.jbit.dao.UserDao;
import com.jbit.entity.Md5;
import com.jbit.entity.User;
@Repository
public class UserDaoImpl extends BaseDaoHibernate implements UserDao {

	@Override
	public User findLogin(User user) {
		List<User> list=(List<User>) super.getHibernateTemplate().find("from User where name=? and password=? and USERDOMAIN=? and USERNAME=?",user.getName(),Md5.md5Password(user.getPassword()),user.getUSERDOMAIN(),user.getUSERNAME());
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
		
	}

	@Override
	public List<User> findPageList( final Integer first,final Integer max) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
			@Override
			public List<User> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=(Query) session.createQuery("from User");
				query.setFirstResult(first);
				query.setMaxResults(max);
				return query.list();
			}
		});
	}

	@Override
	public Object findCount() {
		return super.getHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=(Query) session.createQuery("select count(*) from User");
				return  query.uniqueResult() ;
			}
		});
	}

	@Override
	public List<User> findAll() {
		return super.getHibernateTemplate().find("from User");
	}

	@Override
	public void insertUser(User user) {
		super.getHibernateTemplate().merge(user);
	}
	
}
