package com.ethan.keyboardstore.model;

import java.math.BigDecimal;

import com.ethan.keyboardstore.dto.Product;

// TODO: Change from DTO to entity and store in the database.
public class Receipt {
	Long id;
	String productName;
	BigDecimal productPrice;
	int productQuantity;
	
	public Receipt(Product product) {
		this.id = new Long(1);
		this.productName = product.getName();
		this.productPrice = product.getPrice();
		this.productQuantity = 1;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
}
