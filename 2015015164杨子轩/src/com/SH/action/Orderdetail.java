package com.SH.action;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class Orderdetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderdetail_id")
	private Integer orderdetail_id;
	@Column(name="count")
	private Integer count;
	@ManyToOne
    @JoinColumn(name="order_id")
	private Order order;
	@ManyToOne
    @JoinColumn(name="book_id")
	private Book book;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Integer getOrderdetail_id() {
		return orderdetail_id;
	}
	public void setOrderdetail_id(Integer orderdetail_id) {
		this.orderdetail_id = orderdetail_id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}	
}
