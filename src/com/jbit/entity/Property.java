package com.jbit.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Property entity. @author MyEclipse Persistence Tools
 */

public class Property implements java.io.Serializable {

	// Fields

	private Integer id;
	private Category category;
	private String name;
	private Timestamp deleteAt;
	private Set<PropertyValue> propertyValues = new HashSet<PropertyValue>();

	// Constructors

	/** default constructor */
	public Property() {
	}

	/** minimal constructor */
	public Property(String name) {
		this.name = name;
	}


	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDeleteAt() {
		return this.deleteAt;
	}

	public void setDeleteAt(Timestamp deleteAt) {
		this.deleteAt = deleteAt;
	}

	public Set<PropertyValue> getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(Set<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
	}


}