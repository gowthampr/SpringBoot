package com.company.gp.library.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.company.gp.library.entity.Book;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer{

	@Value("${allowedurl}")
	String allowedUrl;

	@Value("${server.port}")
	String port;
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,
			CorsRegistry cors) {
		// TODO Auto-generated method stub
		
		HttpMethod[] unsupportedMethods = {HttpMethod.POST, 
		                                   HttpMethod.PUT, 
		                                   HttpMethod.DELETE, 
		                                   HttpMethod.PATCH};
		config.exposeIdsFor(Book.class);
		config.getExposureConfiguration().forDomainType(Book.class)
		.withItemExposure((metadata, httpmethods)->httpmethods.disable(unsupportedMethods))
		.withCollectionExposure((metadata, httpmethods) -> httpmethods.disable(unsupportedMethods));
		
		/**CORS***/
		
		cors.addMapping(config.getBasePath()+"/**").allowedOriginPatterns("*");
		
	}
	
	
	
}
