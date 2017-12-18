package com.SH.action;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="user_name")
	private String user_name;
	@Column(name="user_password")
	private String user_password;
	@Column(name="user_email")
	private String user_email;
	@Column(name="IDnumber")
	private String IDnumber;
	@Column(name="RealName")
	private String RealName;
	@Column(name="user_posttime")
	private String user_posttime;
	@OneToMany(mappedBy="user", targetEntity=Order.class, 
            cascade=CascadeType.ALL)
	private Set<Order> orderSet = new HashSet<Order>();
	
	
	public String getIDnumber() {
		return IDnumber;
	}
	public void setIDnumber(String iDnumber) {
		IDnumber = iDnumber;
	}
	public String getRealName() {
		return RealName;
	}
	public void setRealName(String realName) {
		RealName = realName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_posttime() {
		return user_posttime;
	}
	public void setUser_posttime(String user_posttime) {
		this.user_posttime = user_posttime;
	}
	public Set<Order> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}
	
}
