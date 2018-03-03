package com.gowtham.springboots.microservice.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="User related details.")
@Entity
public class User {

	@Size(min=2, message="Name must have minimum 2 characters.")
	@NotNull
	@ApiModelProperty(notes="Name must have minimum 2 characters")
	private String name;
	
	@Id
	@GeneratedValue
	private int id;
	
	@Past
	@ApiModelProperty(notes="Date of birth must be of past.")
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
