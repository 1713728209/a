package com.jbit.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String orderCode;
	private Double sum;
	private Integer totalNumber;
	private String address;
	private String post;
	private String receiver;
	private String mobile;
	private String userMessage;
	private Timestamp createDate;
	private Timestamp payDate;
	private Timestamp deliverDate;
	private Timestamp confirmDate;
	private Integer status;
	private Timestamp deleteAt;
	private Set<Orderitem> orderitems = new HashSet<Orderitem>();

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(String orderCode, Double sum, Integer totalNumber) {
		this.orderCode = orderCode;
		this.sum = sum;
		this.totalNumber = totalNumber;
	}


	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Double getSum() {
		return this.sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public Integer getTotalNumber() {
		return this.totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserMessage() {
		return this.userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}

	public Timestamp getDeliverDate() {
		return this.deliverDate;
	}

	public void setDeliverDate(Timestamp deliverDate) {
		this.deliverDate = deliverDate;
	}

	public Timestamp getConfirmDate() {
		return this.confirmDate;
	}

	public void setConfirmDate(Timestamp confirmDate) {
		this.confirmDate = confirmDate;
	}

	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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