package com.SH.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.SH.action.Book;
import com.SH.action.User;
import com.SH.service.Userservice;

@Controller
public class UserAction {
	@Autowired
	private Userservice userservice;
	
	@RequestMapping("/Logion")
	public String logion(String username,String password,Model model,HttpServletRequest request) {
		User user = userservice.Logion(username, password);
		if(user!=null) {
			request.getSession().setAttribute("user", user);
			return "index01";
		}else {
			model.addAttribute("errormsg", "您输入的用户名或密码有误,请重新输入");
			return "index";
		}
	}
	
	@RequestMapping("/register")
	public String Register(User u,Model model) {
		boolean flag = userservice.register(u);
		if(flag) {
			return "index";
		}else {
			model.addAttribute("error", "您的注册信息有误,请重新输入");
			return "register";
		}
	}
	
	@RequestMapping("/UserManage")
	public String UserManage(HttpServletRequest request) {
		List<User> list = userservice.selectAllUser();
		request.setAttribute("UserList", list);
		return "UserManage";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request) {
		String id = request.getParameter("userId");
		int id1 = Integer.parseInt(id);
		userservice.deleteUser(id1);
		return "redirect:UserManage.do";
	}
}
