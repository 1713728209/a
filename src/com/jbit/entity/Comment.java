package com.jbit.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Product product;
	private User user;
	private String content;
	private Timestamp createDate;
	private Timestamp deleteAt;
	private Set<Orderitem> orderitems = new HashSet<Orderitem>();

	// Constructors

	/** default constructor */
	public Comment() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getDeleteAt() {
		return this.deleteAt;
	}

	public void setDeleteAt(Timestamp deleteAt) {
		this.deleteAt = deleteAt;
	}

	public Set<Orderitem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Set<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}


}