package com.example.productMs.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.productMs.entity.ProductEntity;
import com.example.productMs.service.ProductService;



@RestController
@EnableEurekaClient
public class ProductController {
	
	@Autowired
	ProductService productServ;
	
	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<?> findProductDetails(@PathVariable Integer productId) {
		final Logger logger;
		logger = LoggerFactory.getLogger(this.getClass());
	    logger.info("Provided product Id in the url "+productId);
	    logger.info(System.getProperty("user.dir"));
		return new ResponseEntity<>(productServ.getProductInfoById(productId),HttpStatus.OK);
	}
	
	@GetMapping(value = "/products/findAll")
	public ResponseEntity<?> findAllProductDetails() {
		return new ResponseEntity<>(productServ.findAllProducts(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/insertProducts")
	public ResponseEntity<?> insertProductDetails(@RequestBody ProductEntity productEntity) {
		final Logger logger;
		logger = LoggerFactory.getLogger(this.getClass());
		String message = "";
		try {
			logger.info("In insertProducts");
			message = "Sucessfully Inserted the product";
			productServ.addProduct(productEntity);
			
		}
		catch (Exception e) {
			message = "productID Already Exists";
			logger.error(e.getMessage());
		}
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
	
	

}
