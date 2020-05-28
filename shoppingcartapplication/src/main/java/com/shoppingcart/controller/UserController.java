package com.shoppingcart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.model.User;
import com.shoppingcart.service.impl.UserServiceImpl;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired private UserServiceImpl userServiceImpl;

	@PostMapping
	public User addUser(@RequestBody User userBody) {
		logger.debug("Add User");
		return userServiceImpl.addUser(userBody); 
	}

	@GetMapping
	public List<User> getUsers() {
		logger.debug("Get Users");
		return userServiceImpl.getusers();
	}
 
	@GetMapping(value = "/{userId}")
	public User getUserDetails(@PathVariable long userId) {
		logger.debug("Get User details by userId");
		return userServiceImpl.getUserDetails(userId);
	}
}
