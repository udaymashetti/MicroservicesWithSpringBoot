package com.example.productMs.exception;

@SuppressWarnings("serial")
public class ProductIdAlreadyPresentException extends Exception  {
	
	public ProductIdAlreadyPresentException(String message){
		super(message);
	}
}
