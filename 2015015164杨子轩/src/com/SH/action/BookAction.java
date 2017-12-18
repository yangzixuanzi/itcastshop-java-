package com.SH.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SH.action.Book;
import com.SH.service.Bookservice;


@Controller
public class BookAction {
	@Autowired
	private Bookservice bookservice;
	
	@RequestMapping("/allBook")
	public String allBook(Model model) {
		List<Book> list = bookservice.selectALL();
		model.addAttribute("list2", list);
		return "front";
	}
	
	@RequestMapping("/hotBook")
	public String hotBook(Model model) {
		List<Book> list = bookservice.selectHot();
		model.addAttribute("list", list);
		return "front";
	}
	
	@RequestMapping("/newBook")
	public String newBook(Model model) {
		List<Book> list = bookservice.selectNew();
		model.addAttribute("list1", list);
		return "front";
	}
	
	@RequestMapping("/buy")
	public String buyBook(HttpServletRequest request) {
		String id = request.getParameter("book_id");
		int bookId = Integer.parseInt(id);
		Book book = bookservice.selectByID(bookId);
		request.setAttribute("book", book);
		return "addCar";
	}
	
	@RequestMapping("/addCar")
	public String addCar(HttpServletRequest request) {
		String book_name = request.getParameter("book_name");
		String count = request.getParameter("count");
		int count1 = Integer.parseInt(count);
		
		System.out.println(book_name);
		System.out.println(count);
		
		List bookList = null;
		List countList = null;
		HttpSession session = request.getSession();
		Object bookList1 = session.getAttribute("bookList1");
		Object countList1 = session.getAttribute("countList1");
		
		if(bookList1==null && countList1==null) {
			bookList = new ArrayList();
			countList = new ArrayList();
			bookList.add(book_name);
			countList.add(count1);
			session.setAttribute("bookList1", bookList);
			session.setAttribute("countList1", countList);
		}else {
			bookList = (List) bookList1;
			countList = (List) countList1;
			bookList.add(book_name);
			countList.add(count1);
			session.setAttribute("bookList1", bookList);
			session.setAttribute("countList1", countList);
		}
		
		return "index03";
	}
	
	@RequestMapping("/showCar")
	public String showCar(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List bookList1 = (List) session.getAttribute("bookList1");
		List countList1 = (List) session.getAttribute("countList1");
		List sumList = null;
		List sumList1 = null;
		boolean flag = false;
		if(bookList1 != null) {
			for(int i=0;i<bookList1.size();i++) {
				sumList1 = (List) session.getAttribute("sumList1");
				if(sumList1==null) {
					flag = true;
				}
				Book book = bookservice.selectByName((String)bookList1.get(i));
				Integer count = (Integer) countList1.get(i);
				String price = book.getBook_price().substring(1);
				int sum = Integer.parseInt(price)*count;
				if(sumList1 == null) {
					sumList = new ArrayList();
					sumList.add(sum);
					session.setAttribute("sumList1", sumList);
				}
				if(sumList1!=null && sumList1.size()<=bookList1.size() && flag==true) {
					sumList = sumList1;
					sumList.add(sum);
					session.setAttribute("sumList1", sumList);
				}
				if(sumList1!=null && sumList1.size()<bookList1.size() && flag==false) {
					sumList = sumList1;
					Book book1 = bookservice.selectByName((String)bookList1.get(sumList1.size()+i));
					Integer count1 = (Integer) countList1.get(sumList1.size()+i);
					String price1 = book1.getBook_price().substring(1);
					int sum1 = Integer.parseInt(price1)*count1;
					sumList.add(sum1);
					session.setAttribute("sumList1", sumList);
				}
				if(sumList1!=null && sumList1.size() == bookList1.size() && flag==false && request.getParameter("num")!=null) {
					String num = request.getParameter("num");
					int number1 = Integer.parseInt(num);
					sumList = sumList1;
					Book book1 = bookservice.selectByName((String)bookList1.get(number1));
					Integer count1 = (Integer) countList1.get(number1);
					String price1 = book1.getBook_price().substring(1);
					int sum1 = Integer.parseInt(price1)*count1;
					sumList.set(number1, sum1);
					session.setAttribute("sumList1", sumList);
				}
			}
			List sumList2 = (List) session.getAttribute("sumList1");
			int sum = 0;
			for(int i=0;i<sumList2.size();i++) {
				sum += (int)sumList2.get(i);
			}
			session.setAttribute("sum", sum);
		}else {
			session.setAttribute("sum", 0);
		}
		if(session.getAttribute("address")!=null && session.getAttribute("phone")!=null) {
			return "showCarTwo";
		}else {
			return "showCar";
		}
	}
	
	@RequestMapping("/update")
	public String update (HttpServletRequest request) {
		String name = request.getParameter("bookName");
		Book book = bookservice.selectByName(name);
		request.setAttribute("book", book);
		return "update";
	}
	
	@RequestMapping("/updateTwo")
	public String updateTwo (HttpServletRequest request) {
		HttpSession session = request.getSession();
		String count = request.getParameter("count");
		String name = request.getParameter("book_name");
		int count1 = Integer.parseInt(count);
		List bookList1 = (List) session.getAttribute("bookList1");
		List countList1 = (List) session.getAttribute("countList1");
		int k = 0;
		for(int i=0;i<bookList1.size();i++) {
			if(bookList1.get(i).equals(name)) {
				k += i;
			}
		}
		countList1.set(k, count1);
		session.setAttribute("countList1", countList1);
		return "redirect:showCar.do?num="+k;
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String name = request.getParameter("bookName");
		String count = request.getParameter("count");
		HttpSession session = request.getSession();
		List bookList1 = (List) session.getAttribute("bookList1");
		List countList1 = (List) session.getAttribute("countList1");
		List sumList1 = (List) session.getAttribute("sumList1");
		for(int i=0;i<bookList1.size();i++) {
			if(bookList1.get(i).equals(name)) {
				bookList1.remove(i);
				countList1.remove(i);
				sumList1.remove(i);
				session.setAttribute("bookList1", bookList1);
				session.setAttribute("countList1", countList1);
				session.setAttribute("sumList1", sumList1);
			}
		}
		return "redirect:showCar.do";
	}
	
	@RequestMapping("/alldelete")
	public String alldelete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("bookList1", null);
		session.setAttribute("countList1", null);
		session.setAttribute("sumList1", null);
		return "redirect:showCar.do";
	}
	
	@RequestMapping("/GoodsManage")
	public String GoodsManage(HttpServletRequest request) {
		List<Book> list = bookservice.selectALL();
		request.setAttribute("bList", list);
		return "GoodsManage";
	}
	
	@RequestMapping("/deleteGoods")
	public String deleteGoods(HttpServletRequest request) {
		String id = request.getParameter("id");
		bookservice.deleteByBookId(Integer.parseInt(id));
		return "redirect:GoodsManage.do";
	}
	
	@RequestMapping("/updateGoods")
	public String updateGoods(HttpServletRequest request) {
		String id = request.getParameter("id");
		Book book = bookservice.selectByID(Integer.parseInt(id));
		request.setAttribute("goods", book);
		return "updateGoods";
	}
	
	@RequestMapping("/updateGoods2")
	public String updateGoods2(HttpServletRequest request) {
		String bookId = request.getParameter("bookId");
		String name = request.getParameter("bookName");
		String bookPublisher = request.getParameter("bookPublisher");
		String bookPrice = request.getParameter("bookPrice");
		String bookTypeName = request.getParameter("bookType");
		bookservice.updateBookById(Integer.parseInt(bookId), name, bookPublisher, bookPrice, bookservice.selectTypeByName(bookTypeName));
		return "redirect:GoodsManage.do";
	}
	
	@RequestMapping("/searchType")
	public String searchType(HttpServletRequest request) {
		String typeName = request.getParameter("typeName");
		List<Book> list = bookservice.selectBookByType(bookservice.selectTypeByName(typeName));
		request.setAttribute("TypeList", list);
		request.setAttribute("typeName", typeName);
		return "searchType";
	}
	
	@RequestMapping("/deleteGoods2")
	public String deleteGoods2(HttpServletRequest request) {
		String typeName = request.getParameter("name");
		String id = request.getParameter("id");
		bookservice.deleteByBookId(Integer.parseInt(id));
		List<Book> list = bookservice.selectBookByType(bookservice.selectTypeByName(typeName));
		request.setAttribute("TypeList", list);
		request.setAttribute("typeName", typeName);
		return "searchType";
	}
	
	@RequestMapping("/updateGoods3")
	public String updateGoods3(HttpServletRequest request) {
		String typeName = request.getParameter("name");
		String id = request.getParameter("id");
		Book book = bookservice.selectByID(Integer.parseInt(id));
		request.setAttribute("goods", book);
		request.setAttribute("typeName", typeName);
		return "updateGoods2";
	}
	
	@RequestMapping("/updateGoods4")
	public String updateGoods4(HttpServletRequest request) {
		String typeName = request.getParameter("typeName");
		String bookId = request.getParameter("bookId");
		String name = request.getParameter("bookName");
		String bookPublisher = request.getParameter("bookPublisher");
		String bookPrice = request.getParameter("bookPrice");
		String bookTypeName = request.getParameter("bookType");
		bookservice.updateBookById(Integer.parseInt(bookId), name, bookPublisher, bookPrice, bookservice.selectTypeByName(bookTypeName));
		List<Book> list = bookservice.selectBookByType(bookservice.selectTypeByName(typeName));
		request.setAttribute("TypeList", list);
		request.setAttribute("typeName", typeName);
		return "searchType";
	}
	
	@RequestMapping("/searchName")
	public String searchName(HttpServletRequest request) {
		String goodsName = request.getParameter("goodsName");
		Book book = bookservice.selectByName(goodsName);
		request.setAttribute("NameBook", book);
		return "searchName";
	}
	
	@RequestMapping("/searchPrice")
	public String searchPrice(HttpServletRequest request) {
		String lowPrice = request.getParameter("lowPrice");
		String highPrice = request.getParameter("highPrice");
		List<Book> list = bookservice.selectBookByPrice(Integer.parseInt(lowPrice), Integer.parseInt(highPrice));
		request.setAttribute("PriceList", list);
		request.setAttribute("lowPrice", lowPrice);
		request.setAttribute("highPrice", highPrice);
		return "searchPrice";
	}
	
	@RequestMapping("/updateGoods5")
	public String updateGoods5(HttpServletRequest request) {
		String id = request.getParameter("id");
		String low = request.getParameter("low");
		String high = request.getParameter("high");
		Book book = bookservice.selectByID(Integer.parseInt(id));
		request.setAttribute("goods", book);
		request.setAttribute("low", low);
		request.setAttribute("high", high);
		return "updateGoods3";
	}
	
	@RequestMapping("/updateGoods6")
	public String updateGoods6(HttpServletRequest request) {
		String low = request.getParameter("low");
		String high = request.getParameter("high");
		String bookId = request.getParameter("bookId");
		String name = request.getParameter("bookName");
		String bookPublisher = request.getParameter("bookPublisher");
		String bookPrice = request.getParameter("bookPrice");
		String bookTypeName = request.getParameter("bookType");
		bookservice.updateBookById(Integer.parseInt(bookId), name, bookPublisher, bookPrice, bookservice.selectTypeByName(bookTypeName));
		List<Book> list = bookservice.selectBookByPrice(Integer.parseInt(low), Integer.parseInt(high));
		request.setAttribute("PriceList", list);
		request.setAttribute("lowPrice", low);
		request.setAttribute("highPrice", high);
		return "searchPrice";
	}
	
	@RequestMapping("/deleteGoods3")
	public String deleteGoods3(HttpServletRequest request) {
		String id = request.getParameter("id");
		String low = request.getParameter("low");
		String high = request.getParameter("high");
		bookservice.deleteByBookId(Integer.parseInt(id));
		List<Book> list = bookservice.selectBookByPrice(Integer.parseInt(low), Integer.parseInt(high));
		request.setAttribute("PriceList", list);
		request.setAttribute("lowPrice", low);
		request.setAttribute("highPrice", high);
		return "searchPrice";
	}
}
