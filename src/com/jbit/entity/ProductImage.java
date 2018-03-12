package com.jbit.entity;

import java.sql.Timestamp;

/**
 * ProductImage entity. @author MyEclipse Persistence Tools
 */

public class ProductImage implements java.io.Serializable {

	// Fields

	private Integer id;
	private Product product;
	private String type;
	private Timestamp deleteAt;

	// Constructors

	/** default constructor */
	public ProductImage() {
	}

	/** full constructor */
	public ProductImage(Product product, String type, Timestamp deleteAt) {
		this.product = product;
		this.type = type;
		this.deleteAt = deleteAt;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getDeleteAt() {
		return this.deleteAt;
	}

	public void setDeleteAt(Timestamp deleteAt) {
		this.deleteAt = deleteAt;
	}

}