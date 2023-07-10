package com.tawny.spring.test.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.spring.test.mybatis.domain.Real_estate;
import com.tawny.spring.test.mybatis.repository.Real_estateRepository;

@Service
public class Real_estateService {
	
	@Autowired
	private Real_estateRepository real_estateRepository;
	
	public Real_estate getReal_estate(int id) {
		Real_estate real_estate = real_estateRepository.selectReal_estate(id);
		return real_estate;
	}
	
	
	@Autowired
	private Real_estateRepository real_estateRepositoryRentPrice;
	
	public Real_estate getReal_estateRentPrice(int rentPrice) {
		Real_estate real_estateRentPrice = real_estateRepositoryRentPrice.selectReal_estateRentPrice(rentPrice);
		return real_estateRentPrice;
	}
	
	
	@Autowired
	private Real_estateRepository real_estateRepositoryAreaPrice;
	
	public Real_estate getReal_estaetAreaPrice(int area, int price) {
		Real_estate real_estateAreaPrice = real_estateRepositoryAreaPrice.selectReal_estateAreaPrice(area, price);
		retutn real_estateAreaPrice;
	}
	
	
	
}
