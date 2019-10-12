package com.hcl.ordermanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class OrderDTO {

	@Id
	@GeneratedValue
	@Column(name= "ORDER_ID")
	long orderId;
	
	@Column(name="QUANTITY")
	float quantity;
	
	@Column(name="PRICE")
	double price;
	
	@Column(name="TYPE")
	String type;
	
	@Column(name="USERID")
	String userId;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
