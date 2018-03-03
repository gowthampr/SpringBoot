package com.gowtham.springboots.microservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoService extends JpaRepository<User, Integer>{
	
	
	
}
