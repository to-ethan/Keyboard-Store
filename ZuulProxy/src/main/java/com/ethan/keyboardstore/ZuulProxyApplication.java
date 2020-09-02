package com.ethan.keyboardstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.ethan.keyboardstore.filters.LogRequestFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulProxyApplication.class, args);
	}

	@Bean
	public LogRequestFilter getFilter() {
		return new LogRequestFilter();
	}
}
