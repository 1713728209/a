package com.jbit.entity;

import java.sql.Timestamp;

/**
 * PropertyValue entity. @author MyEclipse Persistence Tools
 */

public class PropertyValue implements java.io.Serializable {

	// Fields

	private Integer id;
	private Product product;
	private Property property;
	private String value;
	private Timestamp deleteAt;

	// Constructors

	/** default constructor */
	public PropertyValue() {
	}

	/** minimal constructor */
	public PropertyValue(String value) {
		this.value = value;
	}

	/** full constructor */
	public PropertyValue(Product product, Property property, String value, Timestamp deleteAt) {
		this.product = product;
		this.property = property;
		this.value = value;
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

	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Timestamp getDeleteAt() {
		return this.deleteAt;
	}

	public void setDeleteAt(Timestamp deleteAt) {
		this.deleteAt = deleteAt;
	}

}