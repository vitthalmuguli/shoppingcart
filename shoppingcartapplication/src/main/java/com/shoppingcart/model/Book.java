package com.shoppingcart.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Entity
@DiscriminatorValue("2")
public class Book extends Product {

	private String genre;
	private String author;
	private String publications;

	public Book(String genre, String author, String publications, String prodName, float price) {
		super(prodName, price);
		this.genre = genre;
		this.author = author;
		this.publications = publications;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [genre=" + genre + ", author=" + author + ", publications=" + publications + "]";
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublications() {
		return publications;
	}

	public void setPublications(String publications) {
		this.publications = publications;
	}
}
