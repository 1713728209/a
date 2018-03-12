package com.jbit.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.jbit.dao.OrderDao;
import com.jbit.entity.Order;
@Repository
public class OrderDaoImpl extends BaseDaoHibernate implements OrderDao {

	@Override
	public List<Order> findPageList(final Integer first, final Integer max,final Integer uid,final String address) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Order>>() {
			@Override
			public List<Order> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=null;
				if(uid!=null && address!=null){
					query=session.createQuery("from Order where user.id=? and address like ?  order by id asc");
					query.setParameter(0, uid);
					query.setParameter(1,"%"+address+"%");
				}else if(uid==null && address!=null){
					query=session.createQuery("from Order where address like ?  order by id asc");
					query.setParameter(0, "%"+address+"%");
				}else if(uid==null && address==null){
					query=session.createQuery("from Order order by id asc");
				}else if(uid!=null && address==null){
					query=session.createQuery("from Order where user.id = ?  order by id asc");
					query.setParameter(0, uid);
				}
				query.setFirstResult(first);
				query.setMaxResults(max);
				return query.list();
			}
		});
	}

	@Override
	public Integer findcount(final Integer uid,final String address) {
		return super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=null;
				if(uid!=null && address!=null){
					query=session.createQuery("select count(*) from Order where user.id=? and address like ?  order by id asc");
					query.setParameter(0, uid);
					query.setParameter(1, "%"+address+"%");
				}else if(uid==null && address!=null){
					query=session.createQuery("select count(*) from Order where address like ?  ");
					query.setParameter(0, "%"+address+'%');
				}else if(uid==null && address==null){
					query=session.createQuery("select count(*) from Order");
				}else if(uid!=null && address==null){
					query=session.createQuery("select count(*) from Order where user.id = ?");
					query.setParameter(0, uid);
				}
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}

	@Override
	public Integer updateStatus(Integer id) {
		return super.getHibernateTemplate().bulkUpdate("update Order set status=1 where id=?", id);
	}

	@Override
	public List<Order> findAll() {
		return super.getHibernateTemplate().find("from Order");
	}

	@Override
	public Order findOrderById(Integer oid) {
		return super.getHibernateTemplate().get(Order.class, oid);
	}

	@Override
	public Integer updateStatus2(Integer oid) {
		return super.getHibernateTemplate().bulkUpdate("update Order set status=4 where id=?", oid);
	}
	
	@Override
	public Integer updateStatus3(Integer oid) {
		return super.getHibernateTemplate().bulkUpdate("update Order set status=3 where id=?", oid);
	}
}
