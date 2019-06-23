package com.lasky.rest.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lasky.RestTemplate.models.CustomResponseBody;
import com.lasky.RestTemplate.models.User;
import com.lasky.RestTemplate.services.UsersService;
import com.lasky.RestTemplate.utilities.Utility;

@RestController
public class UsersRestController {
	private static Logger logger = LogManager.getLogger(UsersRestController.class);
	
	@Autowired
	UsersService usersService;
	
	private Utility utility = Utility.getOnlyInstance();
	
	@RequestMapping("/")
    public String index() {
    	logger.info("index() { ");
    	
    	logger.info("Process ID: " + Utility.getOnlyInstance().getSystemProcessIdLightWeightProcessId());
    	
    	logger.info("} index()");
        return "Greetings from Rest Template version 0.0.1<br \\>COPYRIGHT © 2018 Lasky!";
    }
	
	@RequestMapping(
    		value = "/users/byid/{id}"
			,method = RequestMethod.GET
			,produces = MediaType.APPLICATION_JSON_VALUE
			,consumes = MediaType.APPLICATION_JSON_VALUE
    		)
    public ResponseEntity<CustomResponseBody<User>> getUser(
    	@PathVariable(value = "id", required = true) final Integer id
    	) {
		String methodName = "getUser";
		logger.info(methodName + "(id: " + id + ")");
		logger.info("Process ID: " + Utility.getOnlyInstance().getSystemProcessIdLightWeightProcessId());
		
		ResponseEntity<CustomResponseBody<User>> responseEntity = null;
		
		responseEntity = this.usersService.getUser(id);
		
		return responseEntity;
	}
	
	@RequestMapping(
		value = "/users/byusername/{username}"
		,method = RequestMethod.GET
		,produces = MediaType.APPLICATION_JSON_VALUE
		,consumes = MediaType.APPLICATION_JSON_VALUE
		)
    public ResponseEntity<CustomResponseBody<User>> getUser(
    	@PathVariable(value = "username", required = true) final String username
    	) {
		String methodName = "getUser";
		logger.info(methodName + "(username: " + username + ")");
		logger.info("Process ID: " + Utility.getOnlyInstance().getSystemProcessIdLightWeightProcessId());
		
		ResponseEntity<CustomResponseBody<User>> responseEntity = null;
		
		responseEntity = this.usersService.getUser(username);
		
		return responseEntity;
	}
	
	@RequestMapping(
		value = "/users"
		,method = RequestMethod.POST
		,produces = MediaType.APPLICATION_JSON_VALUE
		,consumes = MediaType.APPLICATION_JSON_VALUE
		)
	public ResponseEntity<CustomResponseBody<User>> save(
		@RequestBody final User user) {
		
		String methodName = "save";
		logger.info(methodName + "(user: " + utility.toJsonString(user) + ")");
		logger.info("Process ID: " + Utility.getOnlyInstance().getSystemProcessIdLightWeightProcessId());
		
		ResponseEntity<CustomResponseBody<User>> responseEntity = null;
		
		responseEntity = this.usersService.save(user);
		
		return responseEntity;
	}
	
	
}
