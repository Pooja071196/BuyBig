package com.niit.BuyBigBackend.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class OrderItems {
	
	@Id
	
	
	private String orderItemsId;
	
	private String productId;
	
	@ManyToOne
	@JoinColumn(name="orderId")

	private Order order;
	@OneToOne
	@JoinColumn(name="payId")
	private Pay pay;

	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public String getOrderItemsId() {
		return orderItemsId;
	}

	public void setOrderItemsId(String orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	

}
