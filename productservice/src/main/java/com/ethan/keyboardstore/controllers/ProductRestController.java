package com.ethan.keyboardstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethan.keyboardstore.model.Product;
import com.ethan.keyboardstore.repos.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Autowired
	ProductRepo productRepo;
	
	@PostMapping(value = "/product")
	public Product create(@RequestBody Product product) {
		return productRepo.save(product);
	}
}
