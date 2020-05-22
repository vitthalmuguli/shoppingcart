package com.shoppingcart.service.impl;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.exception.CartException;
import com.shoppingcart.exception.InvalidProductId;
import com.shoppingcart.exception.InvalidUserId;
import com.shoppingcart.exception.ParsingException;
import com.shoppingcart.model.Cart;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.User;
import com.shoppingcart.repository.ProductRepository;
import com.shoppingcart.repository.UserRepository;
import com.shoppingcart.service.CartService;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Service
@Transactional(readOnly = true)
public class CartServiceImpl implements CartService {
	
	@Autowired private UserRepository userrepository;

	@Autowired private ProductRepository productRepository;

	@Transactional(readOnly = false)
	public Cart addProductsToCart(Map<String, String> cartBody) {
		User user = new User();
		Long userId = null;
		Long productId = null;
		try {
			userId = Long.parseLong(cartBody.get("userId"));
		} catch (Exception e) {
			throw new ParsingException("user Id Parsing Exception");
		}
		try {
			productId = Long.parseLong(cartBody.get("productId"));
		} catch (Exception e) {
			throw new ParsingException("Product Id Parsing Exception");
		}
		Optional<User> userOptional = userrepository.findById(userId);
		if (userOptional.isPresent()) {
			user = userOptional.get();
			Optional<Product> productOptional = productRepository.findById(productId);
			if (productOptional.isPresent()) {
				Product product = productOptional.get();
				if (user.getCart().getQuantity().containsKey(productId)) {
					user.getCart().getQuantity().put(productId, user.getCart().getQuantity().get(productId) + 1);
					user.getCart().setTotalPrice(user.getCart().getTotalPrice() + product.getPrice());
				} else {
					user.getCart().getProducts().add(product);
					user.getCart().getQuantity().put(productId, 1);
					user.getCart().setTotalPrice(user.getCart().getTotalPrice() + product.getPrice());
				}

			} else {
				throw new InvalidProductId("Product is not found with the given Id");
			}

		} else {
			throw new InvalidUserId("User is not found with the given Id");
		}

		return userrepository.save(user).getCart();
	}

	@Transactional(readOnly = false)
	public Cart updateCart(Map<String, String> cartBody) {

		User user = new User();
		Long userId = null;
		Long productId = null;
		try {
			userId = Long.parseLong(cartBody.get("userId"));
		} catch (Exception e) {
			throw new ParsingException("user Id Parsing Exception");
		}
		try {
			productId = Long.parseLong(cartBody.get("productId"));
		} catch (Exception e) {
			throw new ParsingException("Product Id Parsing Exception");
		}
		Optional<User> userOptional = userrepository.findById(userId);
		if (userOptional.isPresent()) {
			user = userOptional.get();
			Optional<Product> productOptional = productRepository.findById(productId);
			if (productOptional.isPresent()) {
				Product product = productOptional.get();
				if (user.getCart().getQuantity().get(productId) > 1) {
					user.getCart().getQuantity().put(productId, user.getCart().getQuantity().get(productId) - 1);
					user.getCart().setTotalPrice(user.getCart().getTotalPrice() - product.getPrice());
				} else {
					user.getCart().getProducts().remove(product);
					user.getCart().getQuantity().remove(productId);
					user.getCart().setTotalPrice(user.getCart().getTotalPrice() - product.getPrice());
				}

			} else {
				throw new InvalidProductId("Product is not found with the given Id");
			}

		} else {
			throw new InvalidUserId("User is not found with the given Id");
		}

		return userrepository.save(user).getCart();
	}

	@Transactional(readOnly = false)
	public Cart removeproduct(Map<String, String> cartBody) {

		User user = new User();
		Long userId = null;
		Long productId = null;
		try {
			userId = Long.parseLong(cartBody.get("userId"));
		} catch (Exception e) {
			throw new ParsingException("user Id Parsing Exception");
		}
		try {
			productId = Long.parseLong(cartBody.get("productId"));
		} catch (Exception e) {
			throw new ParsingException("Product Id Parsing Exception");
		}
		Optional<User> userOptional = userrepository.findById(userId);
		if (userOptional.isPresent()) {
			user = userOptional.get();
			Optional<Product> productOptional = productRepository.findById(productId);
			if (productOptional.isPresent()) {
				Product product = productOptional.get();
				if (user.getCart().getProducts().contains(product)) {
					user.getCart().getProducts().remove(product);
					user.getCart().getQuantity().remove(productId);
					float removePrice = user.getCart().getQuantity().get(productId) * product.getPrice();
					user.getCart().setTotalPrice(user.getCart().getTotalPrice() - removePrice);
				}
			}

			else {
				throw new InvalidProductId("Product is not found with the given Id");
			}

		} else {
			throw new InvalidUserId("User is not found with the given Id");
		}

		return userrepository.save(user).getCart();

	}

	@Transactional(readOnly = false)
	public Cart removeWholeCart(long userId) {
		User user = new User();
		Optional<User> userOptional = userrepository.findById(userId);
		if (userOptional.isPresent()) {
			user = userOptional.get();
			user.getCart().getProducts().clear();
			user.getCart().getQuantity().clear();
			user.getCart().setTotalPrice(0);
		} else {
			throw new InvalidUserId("User is not found with the given Id");
		}

		return userrepository.save(user).getCart();
	}

	public Cart getCartDetails(long userId) {
		User user = new User();
		Optional<User> userOptional = userrepository.findById(userId);
		if (userOptional.isPresent()) {
			user = userOptional.get();
			if (user.getCart() != null)
				return user.getCart();
			else
				throw new CartException("Cart is Empty");
		} else {
			throw new InvalidUserId("User is not found with the given Id");
		}
	}
}
