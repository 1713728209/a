package com.jbit.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer id;
	private Category category;
	private String name;
	private String subTitle;
	private Double originalPrice;
	private Double nowPrice;
	private Integer stock;
	private Integer imgid;
	private Timestamp createDate;
	private Integer commentCount;
	private Integer saleCount;
	private Timestamp deleteAt;
	private Set<Cartitem> cartitems = new HashSet<Cartitem>();
	private Set<Comment> comments = new HashSet<Comment>();
	private Set<PropertyValue> propertyValues = new HashSet<PropertyValue>();
	private Set<Orderitem> orderitems = new HashSet<Orderitem>();
	private Set<ProductImage> productImages = new HashSet<ProductImage>();

	// Constructors

	/** default constructor */
	public Product() {
	}

	public Product(Integer id, Category category, String name, String subTitle, Double originalPrice, Double nowPrice,
			Integer stock, Integer imgid, Timestamp createDate, Integer commentCount, Integer saleCount,
			Timestamp deleteAt) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.subTitle = subTitle;
		this.originalPrice = originalPrice;
		this.nowPrice = nowPrice;
		this.stock = stock;
		this.imgid = imgid;
		this.createDate = createDate;
		this.commentCount = commentCount;
		this.saleCount = saleCount;
		this.deleteAt = deleteAt;
	}

	/** minimal constructor */
	public Product(String name, String subTitle, Double originalPrice, Double nowPrice, Integer stock,
			Integer commentCount, Integer saleCount) {
		this.name = name;
		this.subTitle = subTitle;
		this.originalPrice = originalPrice;
		this.nowPrice = nowPrice;
		this.stock = stock;
		this.commentCount = commentCount;
		this.saleCount = saleCount;
	}

	/** full constructor */
	public Product(Category category, String name, String subTitle, Double originalPrice, Double nowPrice,
			Integer stock, Integer imgid, Timestamp createDate, Integer commentCount, Integer saleCount,
			Timestamp deleteAt, Set cartitems, Set comments, Set propertyValues, Set orderitems, Set productImages) {
		this.category = category;
		this.name = name;
		this.subTitle = subTitle;
		this.originalPrice = originalPrice;
		this.nowPrice = nowPrice;
		this.stock = stock;
		this.imgid = imgid;
		this.createDate = createDate;
		this.commentCount = commentCount;
		this.saleCount = saleCount;
		this.deleteAt = deleteAt;
		this.cartitems = cartitems;
		this.comments = comments;
		this.propertyValues = propertyValues;
		this.orderitems = orderitems;
		this.productImages = productImages;
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

	public String getSubTitle() {
		return this.subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Double getOriginalPrice() {
		return this.originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Double getNowPrice() {
		return this.nowPrice;
	}

	public void setNowPrice(Double nowPrice) {
		this.nowPrice = nowPrice;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getImgid() {
		return this.imgid;
	}

	public void setImgid(Integer imgid) {
		this.imgid = imgid;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getCommentCount() {
		return this.commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getSaleCount() {
		return this.saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
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

	public Set<PropertyValue> getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(Set<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
	}

	public Set<Orderitem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Set<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public Set<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ProductImage> productImages) {
		this.productImages = productImages;
	}


}