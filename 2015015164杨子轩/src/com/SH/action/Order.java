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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private Integer order_id;
	@Column(name="order_time")
	private String order_time;
	@Column(name="order_state")
	private String order_state;
	@ManyToOne
    @JoinColumn(name="user_id")
	private User user;
	@OneToMany(mappedBy="order", targetEntity=Orderdetail.class, 
            cascade=CascadeType.ALL)
	private Set<Orderdetail> orderdetailSet = new HashSet<Orderdetail>();
	
	public Set<Orderdetail> getOrderdetailSet() {
		return orderdetailSet;
	}
	public void setOrderdetailSet(Set<Orderdetail> orderdetailSet) {	
		this.orderdetailSet = orderdetailSet;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}