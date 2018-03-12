package com.jbit.entity;

import java.sql.Timestamp;

/**
 * Orderitem entity. @author MyEclipse Persistence Tools
 */

public class Orderitem implements java.io.Serializable {

	// Fields

	private Integer id;
	private Comment comment;
	private Order order;
	private Product product;
	private Integer number;
	private Double sum;
	private Timestamp deleteAt;

	// Constructors

	/** default constructor */
	public Orderitem() {
	}

	/** minimal constructor */
	public Orderitem(Integer number, Double sum) {
		this.number = number;
		this.sum = sum;
	}

	/** full constructor */
	public Orderitem(Comment comment, Order order, Product product, Integer number, Double sum, Timestamp deleteAt) {
		this.comment = comment;
		this.order = order;
		this.product = product;
		this.number = number;
		this.sum = sum;
		this.deleteAt = deleteAt;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getSum() {
		return this.sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public Timestamp getDeleteAt() {
		return this.deleteAt;
	}

	public void setDeleteAt(Timestamp deleteAt) {
		this.deleteAt = deleteAt;
	}

}