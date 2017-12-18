package com.SH.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SH.action.Book;
import com.SH.action.Order;
import com.SH.action.User;

@Repository
@Transactional
public class orderDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean insert(Order order,HttpServletRequest request) {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("");
		String postTime = sf.format(date);
		
		order.setOrder_time(postTime);
		order.setOrder_state("未发货");
		User user = (User) request.getSession().getAttribute("user");
		order.setUser(user);
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
		return true;
	}
	
	public List<Order> selectAllOrder() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order");
		List<Order> list = query.list();
		return list;
	}
	
	public List<Order> selectByUser(User u) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order where user = ?");
		query.setParameter(0, u);
		List<Order> list = query.list();
		return list;
	}
	
	public int deleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Order where order_id = ?");
		query.setParameter(0, id);
		int ret = query.executeUpdate();
		return ret;
	}
	
	public Order selectById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Order where order_id = ?");
		query.setParameter(0, id);
		Order order = (Order)query.uniqueResult();
		return order;
	}
	
	public int updateById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Order set order_state = ? where order_id = ?");
		query.setParameter(0, "已发货");
		query.setParameter(1, id);
		int ret = query.executeUpdate();
		return ret;
	}
}
