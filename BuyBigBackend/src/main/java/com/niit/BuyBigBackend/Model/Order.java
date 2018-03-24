package com.niit.BuyBigBackend.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Orders")
@Component

public class Order {
	@Id
	
	
	
	
	
private String orderId;
	
	private String grandTotal;
	
	private String orderDate;
	
	private String orderTime;
	@OneToMany(mappedBy="order")
	private List<OrderItems> orderitems;

@OneToOne
@JoinColumn(name="billId")
private Billing billing;

@OneToOne
@JoinColumn(name="shippingId")
private Shipping shipping;
@OneToOne
@JoinColumn(name="userId")
private User user;

	public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

	public Shipping getShipping() {
	return shipping;
}

public void setShipping(Shipping shipping) {
	this.shipping = shipping;
}

	public List<OrderItems> getOrderitems() {
	return orderitems;
}

public void setOrderitems(List<OrderItems> orderitems) {
	this.orderitems = orderitems;
}

public Billing getBilling() {
	return billing;
}

public void setBilling(Billing billing) {
	this.billing = billing;
}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	
	public String getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

}
