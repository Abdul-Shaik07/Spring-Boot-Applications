package com.wipro.busbookingproject.exceptionhandler;



public class BusIdNotFoundException extends RuntimeException {
	
	public BusIdNotFoundException(String message) {
		super(message);
	}

}
