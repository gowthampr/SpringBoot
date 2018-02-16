package com.gowtham.springboots.microservice.exceptions;

import java.util.Date;

public class CustomizedExceptionMessage {
	
	String name;
	String details;
	Date date;
	
	public CustomizedExceptionMessage(String name, String details, Date date) {
		super();
		this.name = name;
		this.details = details;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public String getDetails() {
		return details;
	}
	public Date getDate() {
		return date;
	} 
	
	
}
