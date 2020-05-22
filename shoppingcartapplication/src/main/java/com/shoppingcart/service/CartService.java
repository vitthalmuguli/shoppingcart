package com.shoppingcart.service;

import java.util.Map;

import com.shoppingcart.model.Cart;

/**
 * 
 * @author Vitthal Baburao
 *
 */
public interface CartService {

	public Cart addProductsToCart(Map<String, String> cartBody);
}
