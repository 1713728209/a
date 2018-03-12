package com.jbit.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.jbit.dao.ProductDao;
import com.jbit.entity.Product;
@Repository
public class ProductDaoImpl extends BaseDaoHibernate implements ProductDao {

	@Override
	public List<Product> fidnPageList(final Integer first, final Integer max, final Integer cid,final String keyword) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Product>>() {

			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=null;
				if(cid==null && keyword==null){
					query=session.createQuery("from Product order by id asc");
				}else if(cid==null && keyword!=null){
					query=session.createQuery("from Product where name like ? or category.name like ? order by id asc");
					query.setParameter(0, "%"+keyword+"%");
					query.setParameter(1, "%"+keyword+"%");
			    }else if(cid!=null && keyword!=null){
					query=session.createQuery("from Product where name like ? or category.name like ? and category.id=? order by id asc");
					query.setParameter(0, "%"+keyword+"%");
					query.setParameter(1, "%"+keyword+"%");
					query.setParameter(2, cid);
			    }else if(cid!=null && keyword==null){
			    	query=session.createQuery("from Product where category.id=? order by id asc");
					query.setParameter(0, cid);
			    }
				query.setFirstResult(first);
				query.setMaxResults(max);
				return query.list();

			}
		});
	}

	@Override
	public Integer findCount(final Integer cid,final String keyword) {
		return super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=null;
				if(cid==null && keyword==null){
					query=session.createQuery("select count(*) from Product");
				}else if(cid==null && keyword!=null){
					query=session.createQuery("select count(*) from Product where name like ? or category.name like ? ");
					query.setParameter(0, "%"+keyword+"%");
					query.setParameter(1, "%"+keyword+"%");
			    }else if(cid!=null && keyword!=null){
					query=session.createQuery("select count(*) from Product where name like ? or category.name like ? and category.id=? ");
					query.setParameter(0, "%"+keyword+"%");
					query.setParameter(1, "%"+keyword+"%");
					query.setParameter(2, cid);
			    }else if(cid!=null && keyword==null){
			    	query=session.createQuery("select count(*) from Product where category.id=? ");
					query.setParameter(0, cid);
			    }
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}

	@Override
	public Product findById(Integer id) {
		return super.getHibernateTemplate().get(Product.class, id);
	}

	@Override
	public void deleteById(Integer id) {
		super.getHibernateTemplate().delete(super.getHibernateTemplate().get(Product.class, id));
	}
	@Override
	public void updateProduct(Product product) {
		super.getHibernateTemplate().merge(product);
	}
	@Override
	public Integer findCommentCountById(final Integer id) {
		return super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createQuery("select count(*) from Comment where product.id=?");
				query.setParameter(0, id);
				return Integer.parseInt(query.uniqueResult().toString());
			}
		});
	}
	@Override
	public Integer updateProduct2(Product product) {
		return super.getHibernateTemplate().bulkUpdate("update Product set name=?,subTitle=?,originalPrice=?,nowPrice=?,stock=? where id=?",
				product.getName(),product.getSubTitle(),product.getOriginalPrice(),product.getNowPrice(),product.getStock(),product.getId());
	}
	
	@Override
	public void insertProduct(Product product) {
		super.getHibernateTemplate().merge(product);
	}
}
