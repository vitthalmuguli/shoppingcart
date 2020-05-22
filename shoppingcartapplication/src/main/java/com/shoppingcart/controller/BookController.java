package com.shoppingcart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.model.Book;
import com.shoppingcart.service.impl.BookServiceImpl;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@RestController
public class BookController {

	@Autowired private BookServiceImpl bookserviceimpl;

	@PostMapping(value = "/book")
	public Book addBook(@RequestBody Map<String, String> bookBody) {
		return bookserviceimpl.addBook(bookBody);
	}

	@GetMapping(value = "/book")
	public List<Book> getBook() {
		return bookserviceimpl.getBook();
	}
}
