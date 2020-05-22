package com.shoppingcart.model.builder;

import com.shoppingcart.model.Book;

/**
 * 
 * @author Vitthal Baburao
 *
 */
public class BookBuilder {
	private String productName;
	private float price;
	private String genre;
	private String author;
	private String publications;

	public BookBuilder setProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public BookBuilder setPrice(float price) {
		this.price = price;
		return this;
	}

	public BookBuilder setGenre(String genre) {
		this.genre = genre;
		return this;
	}

	public BookBuilder setAuthor(String author) {
		this.author = author;
		return this;
	}

	public BookBuilder setPublications(String publications) {
		this.publications = publications;
		return this;
	}

	public Book bookBuild() {
		Book book = new Book(genre, author, publications, productName, price);
		return book;
	}
}
