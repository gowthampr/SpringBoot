package com.gowtham.springboots.microservice.swagger;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


	public static final Contact CONTACT = new Contact("Gowtham Prasad", "https://www.linkedin.com/in/gowthamprasad/", "gowthamprsd@gmail.com");
	public static final ApiInfo APIINFO_CONSTANT = new ApiInfo("Test Documentation", "Test API Details", "1.0", "urn:tos",
			CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));

	public SwaggerConfig() {
		// TODO Auto-generated constructor stub
	}

	@Bean
	public Docket docket(){
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(APIINFO_CONSTANT).produces(DEFAULT_PRODUCES_CONSUMES).consumes(DEFAULT_PRODUCES_CONSUMES);
	}

}
