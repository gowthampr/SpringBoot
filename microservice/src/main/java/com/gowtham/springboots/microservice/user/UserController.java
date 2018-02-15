package com.gowtham.springboots.microservice.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	
	@Autowired
	UserDaoService uds;
	
	
	@GetMapping(path="/users")
	List<User> getAllUsers(){
		return uds.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	User getUser(@PathVariable int id){
		
		return uds.findOne(id);
		
	}
}
