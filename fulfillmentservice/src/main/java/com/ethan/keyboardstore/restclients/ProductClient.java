package com.ethan.keyboardstore.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ethan.keyboardstore.dto.Product;

@FeignClient("zuul-api-gateway")
public interface ProductClient {
	@GetMapping("/product-service/productapi/products/{id}")
	Product getProduct(@PathVariable("id") Long id);
}