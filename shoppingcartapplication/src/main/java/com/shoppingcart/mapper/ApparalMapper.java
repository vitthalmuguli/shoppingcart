package com.shoppingcart.mapper;

import java.util.Map;

import com.shoppingcart.model.Apparal;
import com.shoppingcart.model.builder.ApparalBuilder;

/**
 * 
 * @author Vitthal Baburao
 *
 */
public class ApparalMapper {

	public static Apparal apparalMapper(Map<String, String> data) {
		String design = data.get("design");
		String type = data.get("type");
		String brand = data.get("brand");
		String productName = data.get("productName");
		float price = Float.parseFloat(data.get("price"));

		ApparalBuilder apparalBuilder = new ApparalBuilder();
		return apparalBuilder.setDesign(design).setBrand(brand).setType(type).setProductName(productName)
				.setPrice(price).apparalBuild();
	}
}
