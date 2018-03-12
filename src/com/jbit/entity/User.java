package com.jbit.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private String group;
	private Timestamp deleteAt;
	private Set<Cartitem> cartitems = new HashSet<Cartitem>();
	private Set<Comment> comments = new HashSet<Comment>();
	private Set<Order> orders = new HashSet<Order>();

	private String USERDOMAIN;
	private String USERNAME;
	// Constructors

	/** default constructor */
	public User() {
	}

	public User(String name, String password, String uSERDOMAIN, String uSERNAME) {
		super();
		this.name = name;
		this.password = password;
		USERDOMAIN = uSERDOMAIN;
		USERNAME = uSERNAME;
	}

	public String getUSERDOMAIN() {
		return USERDOMAIN;
	}

	public void setUSERDOMAIN(String uSERDOMAIN) {
		USERDOMAIN = uSERDOMAIN;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	/** minimal constructor */
	public User(String group) {
		this.group = group;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Timestamp getDeleteAt() {
		return this.deleteAt;
	}

	public void setDeleteAt(Timestamp deleteAt) {
		this.deleteAt = deleteAt;
	}

	public Set<Cartitem> getCartitems() {
		return cartitems;
	}

	public void setCartitems(Set<Cartitem> cartitems) {
		this.cartitems = cartitems;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}


}