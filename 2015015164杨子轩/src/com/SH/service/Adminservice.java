package com.SH.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SH.action.Admin;
import com.SH.dao.adminDao;

@Service
public class Adminservice {
	@Autowired
	private adminDao adminDao;
	
	public Admin Login(String adminName,String adminPassword) {
		return adminDao.select(adminName, adminPassword);
	}
}
