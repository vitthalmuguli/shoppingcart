package com.shoppingcart.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shoppingcart.model.Book;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Service
public interface BookService {

	public Book addBook(Map<String, String> bookBody);

	public List<Book> getBook();
}
