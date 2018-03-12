package com.jbit.entity;

import java.util.Date;

/**
 * Cartitem entity. @author MyEclipse Persistence Tools
 */

public class Cartitem implements java.io.Serializable {

	// Fields

	private Integer id;
	private Product product;
	private User user;
	private Integer number;
	private Double sum;
	private Date deleteAt;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public Date getDeleteAt() {
		return deleteAt;
	}
	public void setDeleteAt(Date deleteAt) {
		this.deleteAt = deleteAt;
	}
	public Cartitem() {
		super();
	}


	
}