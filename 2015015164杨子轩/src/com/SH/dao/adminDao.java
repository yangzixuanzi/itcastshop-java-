package com.SH.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SH.action.Admin;
import com.SH.action.User;

@Repository
@Transactional
public class adminDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Admin select (String adminName,String adminPassword) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Admin where admin_name = ? and admin_password = ?");
		query.setParameter(0, adminName);
		query.setParameter(1, adminPassword);
		Admin admin = (Admin) query.uniqueResult();
		return admin;
	}
}
