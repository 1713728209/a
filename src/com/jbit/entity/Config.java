package com.jbit.entity;

import java.sql.Timestamp;

/**
 * Config entity. @author MyEclipse Persistence Tools
 */

public class Config implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String cname;
	private String value;
	private Integer rate;
	private Timestamp deleteAt;

	// Constructors

	/** default constructor */
	public Config() {
	}

	public Config(Integer id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	/** minimal constructor */
	public Config(Integer rate) {
		this.rate = rate;
	}

	/** full constructor */
	public Config(String name, String cname, String value, Integer rate, Timestamp deleteAt) {
		this.name = name;
		this.cname = cname;
		this.value = value;
		this.rate = rate;
		this.deleteAt = deleteAt;
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

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getRate() {
		return this.rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Timestamp getDeleteAt() {
		return this.deleteAt;
	}

	public void setDeleteAt(Timestamp deleteAt) {
		this.deleteAt = deleteAt;
	}

}