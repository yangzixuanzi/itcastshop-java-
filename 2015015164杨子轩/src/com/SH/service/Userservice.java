package com.SH.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SH.action.Book;
import com.SH.action.BookType;
import com.SH.action.User;
import com.SH.dao.userDao;

@Service
public class Userservice {
	@Autowired
	private userDao userDao;
	
	public User Logion(String username,String password) {
		return userDao.select(username, password);
	}
	
	public boolean register(User u) {
		return userDao.insert(u);
	}
	
	public List<User> selectAllUser() {
		return userDao.selectAllUser();
	}
	
	public int deleteUser(int id1) {
		return userDao.deleteUser(id1);
	}
	
	public User selectByName(String name) {
		return userDao.selectByName(name);
	} 
}
