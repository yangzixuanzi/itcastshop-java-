package com.SH.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SH.action.Admin;
import com.SH.service.Adminservice;

@Controller
public class AdminAction {
	@Autowired
	private Adminservice adminservice;
	
	@RequestMapping("/AdminLogion")
	public String Login(@RequestParam("adminName")String adminName,@RequestParam("adminPassword")String adminPassword,HttpServletRequest request) {
		Admin admin = adminservice.Login(adminName, adminPassword);
		if(admin!=null) {
			request.getSession().setAttribute("admin", admin);
			return "background";
		}else {
			request.setAttribute("error", "ƒ˙ ‰»Îµƒ’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
			return "admin";
		}
	}
}
