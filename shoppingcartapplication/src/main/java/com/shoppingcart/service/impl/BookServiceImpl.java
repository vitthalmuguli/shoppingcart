package com.shoppingcart.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.mapper.BookMapper;
import com.shoppingcart.model.Book;
import com.shoppingcart.repository.BookRepository;
import com.shoppingcart.service.BookService;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

	@Autowired
	public BookRepository bookrepository;

	@Transactional(readOnly = false)
	public Book addBook(Map<String, String> bookBody) {
		return bookrepository.save(BookMapper.bookMapper(bookBody));
	}

	public List<Book> getBook() {
		return bookrepository.findAll();
	}
}
