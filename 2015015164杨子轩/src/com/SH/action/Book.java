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
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id")
	private Integer book_id;
	@Column(name="book_name")
	private String book_name;
	@Column(name="book_publisher")
	private String book_publisher;
	@Column(name="book_price")
	private String book_price;
	@Column(name="book_img")
	private String book_img;
	@ManyToOne
    @JoinColumn(name="type_id")
	private BookType bookType;
	@OneToMany(mappedBy="book", targetEntity=Orderdetail.class, 
            cascade=CascadeType.ALL)
	private Set<Orderdetail> orderdetailSet = new HashSet<Orderdetail>();
	
	public Set<Orderdetail> getOrderdetailSet() {
		return orderdetailSet;
	}
	public void setOrderdetailSet(Set<Orderdetail> orderdetailSet) {
		this.orderdetailSet = orderdetailSet;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public String getBook_price() {
		return book_price;
	}
	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	
}