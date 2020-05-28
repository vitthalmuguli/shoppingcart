package com.shoppingcart.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(ApparalController.class);
	
	@Autowired private ApparalServiceImpl apparalserviceimpl;

	@PostMapping(value = "/apparal")
	public Apparal addApparal(@RequestBody Map<String, String> apparalBody) {
		logger.debug("To addApparal");
		return apparalserviceimpl.addApparal(apparalBody);
	}

	@GetMapping(value = "/apparal")
	public List<Apparal> getApparal() {
		logger.debug("Get apparal");
		return apparalserviceimpl.getApparal();
	}
}
