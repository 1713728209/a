package com.jbit.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer recommend;
	private Timestamp deleteAt;
	private String imgPath;
	private Set<Property> properties = new HashSet<Property>();
	private Set<Product> products = new HashSet<Product>();

	// Constructors

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	/** default constructor */
	public Category() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public Timestamp getDeleteAt() {
		return deleteAt;
	}

	public void setDeleteAt(Timestamp deleteAt) {
		this.deleteAt = deleteAt;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Category(Integer id, String name, Integer recommend, Timestamp deleteAt, Set<Property> properties,
			Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.recommend = recommend;
		this.deleteAt = deleteAt;
		this.properties = properties;
		this.products = products;
	}

	

}