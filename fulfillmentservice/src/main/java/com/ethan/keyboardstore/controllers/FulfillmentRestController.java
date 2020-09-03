package com.ethan.keyboardstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethan.keyboardstore.dto.Product;
import com.ethan.keyboardstore.model.Receipt;
import com.ethan.keyboardstore.restclients.ProductClient;

@RestController
@RequestMapping("/fulfillmentapi")
public class FulfillmentRestController {

	@Autowired
	ProductClient productClient;
	
	// TODO: Add error handling if can't find product through Hystrix
	@GetMapping(value = "/products/{id}")
	public Receipt getReceiptForPurchase(@PathVariable("id") Long id) {
		Product product = productClient.getProduct(id);
		return new Receipt(product);
	}
}
