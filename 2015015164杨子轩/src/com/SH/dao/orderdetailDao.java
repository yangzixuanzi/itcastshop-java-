package com.SH.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SH.action.Order;
import com.SH.action.Orderdetail;

@Repository
@Transactional
public class orderdetailDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean insert(Orderdetail orderdetail) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orderdetail);
		return true;
	}
	
	public List<Orderdetail> selectAllOrderdetail() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Orderdetail");
		List<Orderdetail> list = query.list();
		return list;
	}
	
	public List<Orderdetail> selectByOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Orderdetail where order = ?");
		query.setParameter(0, order);
		List<Orderdetail> list = query.list();
		return list;
	}
	
	public int deleteByOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Orderdetail where order = ?");
		query.setParameter(0, order);
		int ret = query.executeUpdate();
		return ret;
	}
	
	public int updateById(int count1,int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Orderdetail set count = ? where orderdetail_id = ?");
		query.setParameter(0, count1);
		query.setParameter(1, id);
		int ret = query.executeUpdate();
		return ret;
	}
	
	public int deleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Orderdetail where orderdetail_id = ?");
		query.setParameter(0, id);
		int ret = query.executeUpdate();
		return ret;
	}
}
