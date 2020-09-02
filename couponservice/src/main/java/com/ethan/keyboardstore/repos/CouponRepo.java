package com.ethan.keyboardstore.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ethan.keyboardstore.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
