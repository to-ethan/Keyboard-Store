package com.ethan.keyboardstore.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethan.keyboardstore.dto.Coupon;
import com.ethan.keyboardstore.model.Product;
import com.ethan.keyboardstore.repos.ProductRepo;
import com.ethan.keyboardstore.restclients.CouponClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	CouponClient couponClient;

	@HystrixCommand(fallbackMethod = "sendErrorResponse")
	@PostMapping(value = "/products")
	public Product create(@RequestBody Product product) {
		if (couponExistsFor(product)) {
			product.setPrice(getPriceAfterDiscount(product));
		}
		return productRepo.save(product);
	}
	
	public Product sendErrorResponse(Product product) {
		return product;
	}
	
	// Returns true if the coupon field is not empty.
	private boolean couponExistsFor(Product product) {
		// TODO: Perform validation to make sure that the coupon exists.
		return !product.getCouponCode().equals("");
	}

	// Returns price of product by the coupon discount as a percentage.
	private BigDecimal getPriceAfterDiscount(Product product) {
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		return product.getPrice()
				.multiply((new BigDecimal(100).subtract(coupon.getDiscount())).divide(new BigDecimal(100)));
	}
}
