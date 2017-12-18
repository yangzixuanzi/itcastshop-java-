package com.SH.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SH.action.Order;
import com.SH.action.User;
import com.SH.dao.orderDao;

@Service
public class Orderservice {
	@Autowired
	private orderDao orderDao;
	
	public boolean insert(Order order,HttpServletRequest request) {
		return orderDao.insert(order, request);
	}
	
	public List<Order> selectAllOrder() {
		return orderDao.selectAllOrder();
	}
	
	public List<Order> selectByUser(User u) {
		return orderDao.selectByUser(u);
	}
	
	public int deleteById(int id) {
		return orderDao.deleteById(id);
	}
	
	public Order selectById(int id) {
		return orderDao.selectById(id);
	}
	
	public int updateById(int id) {
		return orderDao.updateById(id);
	}
}
