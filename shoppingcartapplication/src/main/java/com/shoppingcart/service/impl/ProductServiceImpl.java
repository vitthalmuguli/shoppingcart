package com.shoppingcart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.exception.InvalidProductId;
import com.shoppingcart.model.Product;
import com.shoppingcart.repository.ProductRepository;
import com.shoppingcart.service.ProductService;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productreporistory;

	public List<Product> getProductDetails() {
		return productreporistory.findAll();
	}

	public List<Product> getProductByType(String type, String value) {
		ArrayList<Product> productslist = new ArrayList<Product>();
		if (type.equals("category")) {
			if (value.equals("book"))
				return productreporistory.getOnlyBook();
			else if (value.equals("Apparal"))
				return productreporistory.getOnlyApparal();
		} else if (type.equals("name")) {
			return productreporistory.findByProdName(value);
		} else {
			Optional<Product> optionalproducts = productreporistory.findById(Long.parseLong(value));

			if (optionalproducts.isPresent()) {
				productslist.add(optionalproducts.get());
				return productslist;
			} else {
				throw new InvalidProductId("Product no found with above Id");
			}

		}
		return productslist;

	}

}
