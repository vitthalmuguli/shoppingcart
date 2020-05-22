package com.shoppingcart.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.model.Cart;
import com.shoppingcart.service.impl.CartServiceImpl;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired private CartServiceImpl cartserviceimpl;

	@PostMapping
	public Cart addCart(@RequestBody Map<String, String> cartBody) {
		return cartserviceimpl.addProductsToCart(cartBody);
	}

	@PutMapping
	public Cart updateCart(@RequestBody Map<String, String> cartBody) {
		return cartserviceimpl.updateCart(cartBody);
	}

	@DeleteMapping
	public Cart removeProduct(@RequestBody Map<String, String> cartBody) {
		return cartserviceimpl.removeproduct(cartBody);
	}

	@DeleteMapping("/remove/{userId}")
	public Cart removeWholeCart(@PathVariable long userId) {
		return cartserviceimpl.removeWholeCart(userId);
	}

	@GetMapping(value = "/{userId}")
	public Cart getCartDetails(@PathVariable long userId) {
		return cartserviceimpl.getCartDetails(userId);
	}
}
