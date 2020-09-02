package com.ethan.keyboardstore.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ethan.keyboardstore.dto.Coupon;

@FeignClient("zuul-api-gateway")
public interface CouponClient {
	@GetMapping("/coupon-service/couponapi/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);
}
