package com.SH.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SH.action.Book;
import com.SH.action.BookType;

@Repository
@Transactional
public class bookDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Book> selectAllBook() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book");
		List<Book> list = query.list();
		return list;
	}
	
	public List<Book> selectHotBook() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book where book_id < 4");
		List<Book> list = query.list();
		for(Book book:list) {
			System.out.println(book.getBook_name());
		}
		return list;
	}
	
	public List<Book> selectNewBook(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book where book_id > 9");
		List<Book> list = query.list();
		return list;
	}
	
	public Book selectByID(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book where book_id = ?");
		query.setParameter(0, id);
		Book book = (Book) query.uniqueResult();
		return book;
	}
	
	public Book selectByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book where book_name = ?");
		query.setParameter(0, name);
		Book book = (Book) query.uniqueResult();
		return book;
	}
	
	public int deleteByBookId(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Book where book_id = ?");
		query.setParameter(0, id);
		int ret = query.executeUpdate();
		return ret;
	}
	
	public int updateBookById(int id,String name,String publisher,String price,BookType type) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Book set book_name = ? , book_publisher = ? , book_price = ? , bookType = ? where book_id = ?");
		query.setParameter(0, name);
		query.setParameter(1, publisher);
		query.setParameter(2, price);
		query.setParameter(3, type);
		query.setParameter(4, id);
		int ret = query.executeUpdate();
		return ret;
	}
	
	public BookType selectTypeByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from BookType where type_name = ?");
		query.setParameter(0, name);
		BookType type = (BookType) query.uniqueResult();
		return type;
	}
	
	public List<Book> selectBookByType(BookType type){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book where bookType = ?");
		query.setParameter(0, type);
		List<Book> list = query.list();
		return list;
	}
	
	public List<Book> selectBookByPrice(int low,int high){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book");
		List<Book> list = query.list();
		List<String> list1 = new ArrayList<String>();
		for(int i=0;i<list.size();i++) {
			list1.add(list.get(i).getBook_price());
		}
		List<Integer> list2 = new ArrayList<Integer>();
		for(int i=0;i<list1.size();i++) {
			if(Integer.parseInt(list1.get(i).substring(1))>=low && Integer.parseInt(list1.get(i).substring(1))<=high) {
				list2.add(1);
			}else {
				list2.add(0);
			}
		}
		List<Book> list3 = new ArrayList<Book>();
		for(int i=0;i<list2.size();i++) {
			if(list2.get(i) == 1) {
				list3.add(list.get(i));
			}
		}
		return list3;
	}
}
