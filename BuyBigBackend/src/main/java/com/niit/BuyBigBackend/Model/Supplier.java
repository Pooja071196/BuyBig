package com.niit.BuyBigBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component

public class Supplier {
	@Id 
	
	private String suppID;
private String suppName;
private String address;
private String phno;
private String email;

public Supplier()
{
	this.suppID="SUPP"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
@OneToMany(mappedBy="supplier")
private List<Product> product;

public String getSuppID() {
	return suppID;
}
public void setSuppID(String suppID) {
	this.suppID = suppID;
}

public String getSuppName() {
	return suppName;
}

public void setSuppName(String suppName) {
	this.suppName = suppName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}
public String getPhno() {
	return phno;
}
public void setPhno(String phno) {
	this.phno = phno;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}

}
