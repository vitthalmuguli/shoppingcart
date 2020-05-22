package com.shoppingcart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.model.Cart;
import com.shoppingcart.model.User;
import com.shoppingcart.repository.UserRepository;
import com.shoppingcart.service.UserService;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired private UserRepository userrepository;

	@Transactional(readOnly = false)
	public User addUser(User userBody) {
		Cart cart = new Cart();
		cart.setTotalPrice(0);
		userBody.setCart(cart);
		return userrepository.save(userBody);
	}

	public List<User> getusers() {
		return userrepository.findAll();
	}

	public User getUserDetails(long userId) {
		Optional<User> userOptional = userrepository.findById(userId);
		User user = userOptional.get();
		return user;
	}
}
