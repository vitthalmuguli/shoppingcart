package com.shoppingcart.mapper;

import java.util.Map;

import com.shoppingcart.model.Book;
import com.shoppingcart.model.builder.BookBuilder;

/**
 * 
 * @author Vitthal Baburao
 *
 */
public class BookMapper {

	public static Book bookMapper(Map<String, String> data) {
		String genre = data.get("genre");
		String author = data.get("author");
		String publications = data.get("publications");
		String productName = data.get("productName");
		float price = Float.parseFloat(data.get("price"));

		BookBuilder bookBuilder = new BookBuilder();
		return bookBuilder.setPublications(publications).setAuthor(author).setGenre(genre).setProductName(productName)
				.setPrice(price).bookBuild();
	}
}
