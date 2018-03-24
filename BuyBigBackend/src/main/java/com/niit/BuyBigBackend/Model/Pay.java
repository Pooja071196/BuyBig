package com.niit.BuyBigBackend.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Pay {
	
	@Id

	private String payId;
	
	private String payementMethod;
	
	private String payementStatus;

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getPayementMethod() {
		return payementMethod;
	}

	public void setPayementMethod(String payementMethod) {
		this.payementMethod = payementMethod;
	}

	public String getPayementStatus() {
		return payementStatus;
	}

	public void setPayementStatus(String payementStatus) {
		this.payementStatus = payementStatus;
	}
	
}
