package com.shoppingcart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingcart.model.Product;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Service
public interface ProductService {

	public List<Product> getProductDetails();
}
