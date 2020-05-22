package com.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.model.Cart;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
