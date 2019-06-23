package com.lasky.RestTemplate.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lasky.RestTemplate.models.CustomResponseBody;
import com.lasky.RestTemplate.models.User;
import com.lasky.RestTemplate.utilities.Utility;

@Service
public class UsersService {
	private static Logger logger = LogManager.getLogger(UsersService.class);
	
	@Autowired
	private UsersGenerator usersGenerator;
	
	private Utility utility = Utility.getOnlyInstance();
	
	public ResponseEntity<CustomResponseBody<User>> getUser(Integer id) {
		String methodName = "getUser";
		logger.info(methodName + "(id: " + id + ")");
		
		ResponseEntity<CustomResponseBody<User>> responseEntity = null;
		User user = null;
		HttpStatus httpStatus = null;
		String message = "";
		CustomResponseBody<User> responseBody = null;
		
		try {
			if (id == null) {
				httpStatus = HttpStatus.BAD_REQUEST;
				message = "Bad Request! Valid ID is needed!";
				throw new Exception(message);
			}
			
			user = this.usersGenerator.getUsersMapById().get(id);
			if (user != null) {
				message = "Found user ID: " + id;
				httpStatus = HttpStatus.OK;
				responseBody = new CustomResponseBody<User>(user, message);
				responseEntity = new ResponseEntity<CustomResponseBody<User>>(responseBody, httpStatus);
				
				logger.info(message);
			} else {
				httpStatus = HttpStatus.NOT_FOUND;
				message = "User ID Not Found!";
				throw new Exception(message);
			}
		} catch (Exception exception) {
			logger.error(exception);
		} finally {
			if (httpStatus == null) {
				httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			}
			
			if (responseBody == null) {
				responseBody = new CustomResponseBody<User>();
				responseBody.setMessage(message);
			}
			if (responseEntity == null) {
				responseEntity = new ResponseEntity<CustomResponseBody<User>>(responseBody, httpStatus);
			}
		}
		
		return responseEntity;
	}
	
	public ResponseEntity<CustomResponseBody<User>> getUser(String username) {
		String methodName = "getUser";
		logger.info(methodName + "(username: " + username + ")");
		
		ResponseEntity<CustomResponseBody<User>> responseEntity = null;
		User user = null;
		HttpStatus httpStatus = null;
		String message = "";
		CustomResponseBody<User> responseBody = null;
		
		try {
			if (username == null) {
				httpStatus = HttpStatus.BAD_REQUEST;
				message = "Bad Request! Valid username is needed!";
				throw new Exception(message);
			}
			
			user = this.usersGenerator.getUsersMapByUsername().get(username);
			if (user != null) {
				message = "Found user: " + username;
				httpStatus = HttpStatus.OK;
				responseBody = new CustomResponseBody<User>(user, message);
				responseEntity = new ResponseEntity<CustomResponseBody<User>>(responseBody, httpStatus);
				
				logger.info(message);
			} else {
				httpStatus = HttpStatus.NOT_FOUND;
				message = "User username Not Found!";
				throw new Exception(message);
			}
		} catch (Exception exception) {
			logger.error(exception);
		} finally {
			if (httpStatus == null) {
				httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			}
			
			if (responseBody == null) {
				responseBody = new CustomResponseBody<User>();
				responseBody.setMessage(message);
			}
			if (responseEntity == null) {
				responseEntity = new ResponseEntity<CustomResponseBody<User>>(responseBody, httpStatus);
			}
		}
		
		return responseEntity;
	}
	
	public ResponseEntity<CustomResponseBody<User>> save(User user) {
		String methodName = "save";
		logger.info(methodName + "(user: " + utility.toJsonString(user) + ")");
		
		ResponseEntity<CustomResponseBody<User>> responseEntity = null;
		HttpStatus httpStatus = null;
		String message = "";
		CustomResponseBody<User> responseBody = null;
		
		try {
			if (user == null) {
				httpStatus = HttpStatus.BAD_REQUEST;
				message = "Bad Request! Valid username is needed!";
				throw new Exception(message);
			} else if (utility.isNullOrEmpty(user.getUsername()) || this.userNameExists(user.getUsername())) {
				httpStatus = HttpStatus.BAD_REQUEST;
				message = "Invalid username!";
				throw new Exception(message);
			} else {
				this.usersGenerator.addUser(user);
				message = "User successfully saved!";
				httpStatus = HttpStatus.OK;
				responseBody = new CustomResponseBody<User>(user, message);
				responseEntity = new ResponseEntity<CustomResponseBody<User>>(responseBody, httpStatus);
			}
		} catch (Exception exception) {
			logger.error(exception);
		} finally {
			if (httpStatus == null) {
				httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			}
			
			if (responseBody == null) {
				responseBody = new CustomResponseBody<User>();
				responseBody.setMessage(message);
			}
			if (responseEntity == null) {
				responseEntity = new ResponseEntity<CustomResponseBody<User>>(responseBody, httpStatus);
			}
		}
		
		return responseEntity;
	}
	
	private boolean userNameExists(String username) {
		boolean result = false;
		
		if (this.usersGenerator.getUsersMapByUsername().containsKey(username)) {
			result = true;
		}
		
		return result;
	}
}



