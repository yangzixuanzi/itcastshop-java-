package com.SH.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SH.action.Book;
import com.SH.action.Order;
import com.SH.action.Orderdetail;
import com.SH.action.User;
import com.SH.service.Bookservice;
import com.SH.service.Orderdetailservice;
import com.SH.service.Orderservice;
import com.SH.service.Userservice;

@Controller
@Transactional
public class OrderAction {
	@Autowired
	private Orderservice orderservice;
	@Autowired
	private Orderdetailservice orderdetailservice;
	@Autowired
	private Bookservice bookservice;
	@Autowired
	private Userservice userservice;
	
	@RequestMapping("/takeOver")
	public String takeOver(HttpServletRequest request) {
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		HttpSession session = request.getSession();
		session.setAttribute("address", address);
		session.setAttribute("phone", phone);
		return "showCarTwo";
	}
	
	@RequestMapping("/addOrder")
	public String addOrder(HttpServletRequest request,Order order,Orderdetail orderdetail) {
		orderservice.insert(order, request);
		HttpSession session = request.getSession();
		List bookList1 = (List) session.getAttribute("bookList1");
		
		System.out.println(bookList1.size());
		
		List countList1 = (List) session.getAttribute("countList1");
		for(int i=0;i<bookList1.size();i++) {
			Book book = bookservice.selectByName((String)bookList1.get(i));
			orderdetail.setBook(book);
			orderdetail.setCount((int)countList1.get(i));
			orderdetail.setOrder(order);
			orderdetailservice.insert(orderdetail);
		}
		session.setAttribute("bookList1", null);
		session.setAttribute("countList1", null);
		session.setAttribute("sumList1", null);
		session.setAttribute("sum", 0);
		return "index03";
	}
	
	@RequestMapping("/showOrder")
	public String showOrder(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		List OrderList1 = (List) request.getSession().getAttribute("OrderList1");
		List<List> OrderdetailList1 = (List) request.getSession().getAttribute("OrderdetailList1");
		List OrderList = null;
		List<List> OrderdetailList = new ArrayList<List>();
		List<Order> list = orderservice.selectByUser(user);
		OrderList = list;
		request.getSession().setAttribute("OrderList1", OrderList);
		for(int i=0;i<list.size();i++) {
			List Orderdetail = orderdetailservice.selectByOrder(list.get(i));
			OrderdetailList.add(Orderdetail);
		}
		request.getSession().setAttribute("OrderdetailList1", OrderdetailList);
		return "showOrder";
	}
	
	@RequestMapping("/deleteOrder")
	public String deleteOrder(HttpServletRequest request) {
		String OrderId = request.getParameter("OrderId");
		int OrderId1 = Integer.parseInt(OrderId);
		orderdetailservice.deleteByOrder(orderservice.selectById(OrderId1));
		orderservice.deleteById(OrderId1);
		return "redirect:showOrder.do";
	}
	
	@RequestMapping("/updateOrder")
	public String updateOrder(HttpServletRequest request) {
		String orderId = request.getParameter("OrderId");
		int orderId1 = Integer.parseInt(orderId);
		Order order = orderservice.selectById(orderId1);
		List<Orderdetail> list = orderdetailservice.selectByOrder(order);
		request.setAttribute("odList", list);
		return "updateOrder";
	}
	
	@RequestMapping("/updateOrderTwo")
	public String updateOrderTwo(HttpServletRequest request) {
		String bookName = request.getParameter("name");
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		Book book = bookservice.selectByName(bookName);
		request.setAttribute("book", book);
		request.setAttribute("id", id1);
		return "updateOrderTwo";
	}
	
	@RequestMapping("/updateOrderThree")
	public String updateOrderThree(HttpServletRequest request) {
		String count = request.getParameter("count");
		int count1 = Integer.parseInt(count);
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		orderdetailservice.updateById(count1, id1);
		return "redirect:showOrder.do";
	}
	
	@RequestMapping("/deleteOrderdetail")
	public String deleteOrderdetail(HttpServletRequest request) {
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		orderdetailservice.deleteById(id1);
		return "redirect:showOrder.do";
	}
	
	@RequestMapping("/OrderManage")
	public String OrderManage(HttpServletRequest request) {
		List<Order> list = orderservice.selectAllOrder();
		request.setAttribute("OrderList", list);
		return "OrderManage";
	}
	
	@RequestMapping("/sendOutgoods")
	public String sendOutgoods(HttpServletRequest request) {
		String id = request.getParameter("orderId");
		orderservice.updateById(Integer.parseInt(id));
		return "redirect:OrderManage.do";
	}
	
	@RequestMapping("/selectOrder")
	public String selectOrder(HttpServletRequest request) {
		String username = request.getParameter("username");
		List<Order> list = orderservice.selectByUser(userservice.selectByName(username));
		request.setAttribute("OrderList1", list);
		request.setAttribute("name1", username);
		return "selectUserOrder";
	}
	
	@RequestMapping("/selectOrder1")
	public String selectOrder1(HttpServletRequest request) {
		String id = request.getParameter("id");
		Order order = orderservice.selectById(Integer.parseInt(id));
		request.setAttribute("Order1", order);
		return "selectUserOrder1";
	}
	
	@RequestMapping("/showDetail")
	public String showDetail(HttpServletRequest request) {
		String id = request.getParameter("orderId1");
		List<Orderdetail> list = orderdetailservice.selectByOrder(orderservice.selectById(Integer.parseInt(id)));
		request.setAttribute("showList", list);
		return "showDetail";
	}
	
	@RequestMapping("/deleteOrder1")
	public String deleteOrder1(HttpServletRequest request) {
		String id = request.getParameter("orderId2");
		orderdetailservice.deleteByOrder(orderservice.selectById(Integer.parseInt(id)));
		orderservice.deleteById(Integer.parseInt(id));
		return "redirect:OrderManage.do";
	}
	
	@RequestMapping("/deleteOrder2")
	public String deleteOrder2(HttpServletRequest request) {
		String id = request.getParameter("orderId1");
		String name = request.getParameter("name");
		orderdetailservice.deleteByOrder(orderservice.selectById(Integer.parseInt(id)));
		orderservice.deleteById(Integer.parseInt(id));
		List<Order> list = orderservice.selectByUser(userservice.selectByName(name));
		request.setAttribute("Order2List", list);
		request.setAttribute("name1", name);
		return "deleteOrder2";
	}
}
