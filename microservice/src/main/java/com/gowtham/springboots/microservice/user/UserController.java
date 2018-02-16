package com.gowtham.springboots.microservice.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.gowtham.springboots.microservice.exceptions.UserNotFoundException;

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

		User user = uds.findOne(id);;

		if(user == null){
			throw new UserNotFoundException("User was not found "+id);
		}

		return user;
	}

	@PostMapping("/users")
	@ResponseStatus(code = HttpStatus.CREATED)
	ResponseEntity<Object> saveUser(@RequestBody User user){


		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();


		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path="/users/{id}")
	User deleteUser(@PathVariable int id){

		User user = uds.deleteById(id);

		if(user != null)
			return user;
		else
			throw new UserNotFoundException("User not found "+id);
	}
}
