package com.shoppingcart.model.builder;

import com.shoppingcart.model.Apparal;

/**
 * 
 * @author Vitthal Baburao
 *
 */
public class ApparalBuilder {

	private String productName;
	private float price;
	private String type;
	private String brand;
	private String design;

	public ApparalBuilder setProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public ApparalBuilder setPrice(float price) {
		this.price = price;
		return this;
	}

	public ApparalBuilder setType(String type) {
		this.type = type;
		return this;
	}

	public ApparalBuilder setBrand(String brand) {
		this.brand = brand;
		return this;
	}

	public ApparalBuilder setDesign(String design) {
		this.design = design;
		return this;
	}

	public Apparal apparalBuild() {
		Apparal apparal = new Apparal(type, brand, design, productName, price);
		return apparal;
	}

}
