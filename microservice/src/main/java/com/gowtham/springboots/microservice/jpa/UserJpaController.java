package com.gowtham.springboots.microservice.jpa;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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

import com.gowtham.springboots.microservice.exceptions.UserNotFoundException;

@RestController
public class UserJpaController {


	@Autowired
	UserDaoService uds;


	@GetMapping(path="/jpa/users")
	List<User> getAllUsers(){
		return uds.findAll();
	}

	@GetMapping(path="/jpa/users/{id}")
	Resource<User> getUser(@PathVariable int id){

		Optional<User> user = uds.findById(id);;

		if(!user.isPresent()){
			throw new UserNotFoundException("User was not found "+id);
		}

		Resource<User> resource = new Resource<User>(user.get());
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}

	@PostMapping("/jpa/users")
	@ResponseStatus(code = HttpStatus.CREATED)
	ResponseEntity<Object> saveUser(@RequestBody User user){
		
		User createduser = uds.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createduser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path="/jpa/users/{id}")
	void deleteUser(@PathVariable int id){

		uds.deleteById(id);
	}
}
