package com.SH.dao;

import org.hibernate.query.Query;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SH.action.Book;
import com.SH.action.Order;
import com.SH.action.User;

@Repository
@Transactional
public class userDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public User select (String username,String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where user_name = ? and user_password = ?");
		query.setParameter(0, username);
		query.setParameter(1, password);
		User user = (User) query.uniqueResult();
		return user;
	}
	
	public boolean insert(User user) {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String postTime = sf.format(date);
		user.setUser_posttime(postTime);
		
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return true;
	}
	
	public List<User> selectAllUser() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		return list;
	}
	
	public int deleteUser(int id1) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from User where id = ?");
		query.setParameter(0, id1);
		int ret = query.executeUpdate();
		return ret;
	}
	
	public User selectByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where user_name = ?");
		query.setParameter(0, name);
		User user = (User)query.uniqueResult();
		return user;
	} 
}
