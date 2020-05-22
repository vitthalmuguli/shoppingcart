package com.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.model.Product;
import com.shoppingcart.service.impl.ProductServiceImpl;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@RestController
public class ProductController {

	@Autowired private ProductServiceImpl productserviceimpl;

	@GetMapping(value = "/product")
	public List<Product> getProducts() {
		return productserviceimpl.getProductDetails();
	}

	@GetMapping(value = "/product/search")
	public List<Product> getProductsByType(@RequestHeader(value = "type", required = false) String type,
			@RequestHeader(value = "value", required = false) String value) {
		return productserviceimpl.getProductByType(type, value);
	}
}
