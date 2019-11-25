package com.example.productMs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productMs.entity.ProductEntity;
import com.example.productMs.exception.ProductIdAlreadyPresentException;
import com.example.productMs.repostory.ProductRepostory;

@Service
public class ProductService {
	
	@Autowired
	ProductRepostory pRepo;
	
	@Autowired
	ProductEntity pentity;
	
	public Optional<ProductEntity> getProductInfoById(int productId)
	{
			
		return pRepo.findById(productId);
	}
	
	public void addProduct(ProductEntity productE) throws ProductIdAlreadyPresentException {
		boolean pe = pRepo.existsById(productE.getProductid());
		if(pe)
			throw new ProductIdAlreadyPresentException("Product Id Already Exists");
		pentity.setProductid(productE.getProductid());
		pentity.setProductDesc(productE.getProductDesc());
		pentity.setProductManufacturer(productE.getProductManufacturer());
		pentity.setProductName(productE.getProductName());
		pentity.setProductType(productE.getProductType());
		pRepo.saveAndFlush(pentity);
		
	}
	
	public List<?> findAllProducts() {
		return pRepo.findAll();
	}
	
	

}
