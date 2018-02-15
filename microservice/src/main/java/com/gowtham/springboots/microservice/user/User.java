package com.gowtham.springboots.microservice.user;

import java.util.Date;

public class User {

	private String name;
	
	private int id;
	
	private Date dob;

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, int id, Date dob) {
		super();
		this.name = name;
		this.id = id;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", dob=" + dob + "]";
	} 
	
	
	
	
}
