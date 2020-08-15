package com.ethan.keyboardstore.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ethan.keyboardstore.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
