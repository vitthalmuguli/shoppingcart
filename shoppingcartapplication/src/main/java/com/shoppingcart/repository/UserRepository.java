package com.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.model.User;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
