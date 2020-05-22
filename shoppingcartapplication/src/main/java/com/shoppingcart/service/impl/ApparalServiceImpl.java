package com.shoppingcart.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.mapper.ApparalMapper;
import com.shoppingcart.model.Apparal;
import com.shoppingcart.repository.ApparalRepository;
import com.shoppingcart.service.ApparalService;

/**
 * 
 * @author Vitthal Baburao
 *
 */
@Service
@Transactional(readOnly = true)
public class ApparalServiceImpl implements ApparalService {

	@Autowired
	private ApparalRepository apparalrepository;

	@Transactional(readOnly = false)
	public Apparal addApparal(Map<String, String> apparalBody) {
		System.out.println("Into Service");
		Apparal apparal = ApparalMapper.apparalMapper(apparalBody);
		System.out.println("Brand is" + apparal.getBrand());

		return apparalrepository.save(apparal);
	}

	public List<Apparal> getApparal() {
		return apparalrepository.findAll();
	}
}
