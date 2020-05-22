package com.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.model.Apparal;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Repository
public interface ApparalRepository extends JpaRepository<Apparal, Long> {

}
