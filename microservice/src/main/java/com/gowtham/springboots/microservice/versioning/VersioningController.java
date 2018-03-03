package com.gowtham.springboots.microservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
 * While deciding think about URI pollution (params and in the url), 
 * Misuse Header and content negotiation type of versioning and caching would not work
 * Can we check the versioning from the browser
 * There is no best suited one
 * 
 * */
public class VersioningController {

	//URI Versioning
	@GetMapping("/v1/person")
	public PersonV1 getPersonV1(){
		
		return new PersonV1("Gowtham Prasad");
		
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getPersonV2(){
		
		return new PersonV2(new Name("Gowtham","Prasad"));
		
	}
	
	//Param Versioning
	@GetMapping(value="/person/param",params="version=1")
	public PersonV1 getPersonParamV1(){
		
		return new PersonV1("Gowtham Prasad");
		
	}
	
	@GetMapping(value="/person/param",params="version=2")
	public PersonV2 getPersonParamV2(){
		
		return new PersonV2(new Name("Gowtham","Prasad"));
		
	}
	
	//Header Versioning
	@GetMapping(value="/person/header",headers="X_API_VERSION=1")
	public PersonV1 getPersonHeaderV1(){
		
		return new PersonV1("Gowtham Prasad");
		
	}
	
	@GetMapping(value="/person/header",headers="X_API_VERSION=2")
	public PersonV2 getPersonHeaderV2(){
		
		return new PersonV2(new Name("Gowtham","Prasad"));
		
	}
	
	@GetMapping(value="/person/produces",produces="application/v1.json")
	public PersonV1 getPersonProducesV1(){
		
		return new PersonV1("Gowtham Prasad");
		
	}
	
	@GetMapping(value="/person/produces",produces="application/v2.json")
	public PersonV2 getPersonProducesV2(){
		
		return new PersonV2(new Name("Gowtham","Prasad"));
		
	}
	
	
	
}
