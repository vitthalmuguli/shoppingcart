package com.shoppingcart.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.shoppingcart.model.Apparal;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Service
public interface ApparalService {
	
	public Apparal addApparal(Map<String, String> apparalBody);
}
