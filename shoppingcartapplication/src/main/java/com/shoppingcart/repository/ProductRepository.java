package com.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.model.Product;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("from Product where product_type = 2")
	List<Product> getOnlyBook();
	
	@Query("from Product where product_type = 1")
	List<Product> getOnlyApparal();
	
	@Query("from Product where prod_name LIKE %?1%")
	List<Product> findByProdName(String name);
}
