package com.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.model.Book;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
