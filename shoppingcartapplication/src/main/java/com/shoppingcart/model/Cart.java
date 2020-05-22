package com.shoppingcart.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Entity
public class Cart implements Comparable<Cart> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private float totalPrice;

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> productslist = new ArrayList<Product>();

	@ElementCollection
	private Map<Long, Integer> quantity = new HashMap<Long, Integer>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return productslist;
	}

	public void setProducts(List<Product> products) {
		this.productslist = products;
	}

	public Map<Long, Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(Map<Long, Integer> quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", products=" + productslist + ", quantity=" + quantity + "]";
	}

	public int compareTo(Cart o) {
		return 0;
	}
}
