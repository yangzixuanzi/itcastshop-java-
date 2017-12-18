package com.SH.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SH.action.Order;
import com.SH.action.Orderdetail;
import com.SH.dao.orderdetailDao;

@Service
public class Orderdetailservice {
	@Autowired
	private orderdetailDao orderdetailDao;
	
	public boolean insert(Orderdetail orderdetail) {
		return orderdetailDao.insert(orderdetail);
	}
	
	public List<Orderdetail> selectAllOrderdetail() {
		return orderdetailDao.selectAllOrderdetail();
	}
	
	public List<Orderdetail> selectByOrder(Order order) {
		return orderdetailDao.selectByOrder(order);
	}
	
	public int deleteByOrder(Order order) {
		return orderdetailDao.deleteByOrder(order);
	}
	
	public int updateById(int count1,int id) {
		return orderdetailDao.updateById(count1, id);
	}
	
	public int deleteById(int id) {
		return orderdetailDao.deleteById(id);
	}
}
