package com.infy.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("ProductMs")
public interface ProductFeignService {
	
	@GetMapping(value = "/products/findAll")
	public ResponseEntity<?> findAllProductDetails() ;

}
