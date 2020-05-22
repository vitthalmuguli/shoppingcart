package com.shoppingcart.service;

import org.springframework.stereotype.Service;

import com.shoppingcart.model.User;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Service
public interface UserService {

	public User addUser(User userBody);
}
