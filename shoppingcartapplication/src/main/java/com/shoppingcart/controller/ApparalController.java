package com.shoppingcart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.model.Apparal;
import com.shoppingcart.service.impl.ApparalServiceImpl;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@RestController
public class ApparalController {

	@Autowired private ApparalServiceImpl apparalserviceimpl;

	@PostMapping(value = "/apparal")
	public Apparal addApparal(@RequestBody Map<String, String> apparalBody) {
		System.out.println("Into Controller");
		return apparalserviceimpl.addApparal(apparalBody);
	}

	@GetMapping(value = "/apparal")
	public List<Apparal> getApparal() {
		return apparalserviceimpl.getApparal();
	}
}
