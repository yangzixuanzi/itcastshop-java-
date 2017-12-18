package com.SH.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SH.action.Book;
import com.SH.action.BookType;
import com.SH.dao.bookDao;

@Service("Bookservice")
public class Bookservice {
	@Autowired
	private bookDao bookDao;
	
	public bookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(bookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public List<Book> selectALL() {
		return bookDao.selectAllBook();
	}

	public List<Book> selectHot() {
		return bookDao.selectHotBook();
	}
	
	public List<Book> selectNew() {
		return bookDao.selectNewBook();
	}
	
	public Book selectByID(Integer id) {
		return bookDao.selectByID(id);
	}
	
	public Book selectByName(String name) {
		return bookDao.selectByName(name);
	}
	
	public int deleteByBookId(int id) {
		return bookDao.deleteByBookId(id);
	}
	
	public int updateBookById(int id,String name,String publisher,String price,BookType type) {
		return bookDao.updateBookById(id, name, publisher, price, type);
	}
	
	public BookType selectTypeByName(String name) {
		return bookDao.selectTypeByName(name);
	}
	
	public List<Book> selectBookByType(BookType type){
		return bookDao.selectBookByType(type);
	}
	
	public List<Book> selectBookByPrice(int low,int high){
		return bookDao.selectBookByPrice(low, high);
	}
}
