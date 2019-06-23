package com.lasky.RestTemplate.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.lasky.RestTemplate.models.User;


@Service
public class UsersGenerator {
	private static Map<Integer, User> usersById;
	private static Map<String, User> usersByUsername;
	private static List<User> listOfUsers;
	
	static {
		if (listOfUsers == null || listOfUsers.isEmpty()) {
			listOfUsers = new ArrayList<User>();
			usersById = new TreeMap<Integer, User>();
			usersByUsername = new TreeMap<String, User>();
			
			User user = new User();
			user.setId(1);
			user.setUsername("user1");
			user.setFullName("User One");
			user.setEmail("user1@test.com");
			user.setAccountType("admin");
			listOfUsers.add(user);
			usersById.put(user.getId(), user);
			usersByUsername.put(user.getUsername(), user);
			
			user = new User();
			user.setId(2);
			user.setUsername("user2");
			user.setFullName("User Two");
			user.setEmail("user2@test.com");
			user.setAccountType("normal");
			listOfUsers.add(user);
			usersById.put(user.getId(), user);
			usersByUsername.put(user.getUsername(), user);
			
			user = new User();
			user.setId(3);
			user.setUsername("user3");
			user.setFullName("User Three");
			user.setEmail("user3@test.com");
			user.setAccountType("normal");
			listOfUsers.add(user);
			usersById.put(user.getId(), user);
			usersByUsername.put(user.getUsername(), user);
			
			user = new User();
			user.setId(4);
			user.setUsername("user4");
			user.setFullName("User Four");
			user.setEmail("user4@test.com");
			user.setAccountType("normal");
			listOfUsers.add(user);
			usersById.put(user.getId(), user);
			usersByUsername.put(user.getUsername(), user);
			
			user = new User();
			user.setId(5);
			user.setUsername("user5");
			user.setFullName("User Five");
			user.setEmail("user5@test.com");
			user.setAccountType("guest");
			listOfUsers.add(user);
			usersById.put(user.getId(), user);
			usersByUsername.put(user.getUsername(), user);
			
			user = new User();
			user.setId(6);
			user.setUsername("user6");
			user.setFullName("User Six");
			user.setEmail("user6@test.com");
			user.setAccountType("guest");
			listOfUsers.add(user);
			usersById.put(user.getId(), user);
			usersByUsername.put(user.getUsername(), user);
			
			user = new User();
			user.setId(7);
			user.setUsername("user7");
			user.setFullName("User Seven");
			user.setEmail("user7@test.com");
			user.setAccountType("guest");
			listOfUsers.add(user);
			usersById.put(user.getId(), user);
			usersByUsername.put(user.getUsername(), user);
		}
	}
	
	public List<User> getAllUsers() {
		return UsersGenerator.listOfUsers;
	}
	
	public Map<Integer, User> getUsersMapById() {
		return UsersGenerator.usersById;
	}
	
	public Map<String, User> getUsersMapByUsername() {
		return UsersGenerator.usersByUsername;
	}
	
	public void addUser(User newUser) {
		Integer id = UsersGenerator.listOfUsers.size() + 1;
		newUser.setId(id);
		listOfUsers.add(newUser);
		usersById.put(newUser.getId(), newUser);
		usersByUsername.put(newUser.getUsername(), newUser);
	}
}


