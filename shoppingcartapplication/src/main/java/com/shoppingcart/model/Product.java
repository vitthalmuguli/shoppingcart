package com.shoppingcart.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type", discriminatorType = DiscriminatorType.INTEGER)
public class Product implements Comparable<Product>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String prodName;
	private float price;
	
	public Product() {
		super();
	}
	
	public Product(String prodName, float price) {
		this.prodName = prodName;
		this.price = price;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", prodName=" + prodName + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int finalNumber = 31;
		int finalValue = 1;
		finalValue = finalNumber * finalValue + Float.floatToIntBits(price);
		finalValue = finalNumber * finalValue + ((prodName == null) ? 0 : prodName.hashCode());
		finalValue = finalNumber * finalValue + (int) (productId ^ (productId >>> 32));
		return finalValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (prodName == null) {
			if (other.prodName != null)
				return false;
		} else if (!prodName.equals(other.prodName))
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}

	public int compareTo(Product o) {
		return 0;
	}
}
