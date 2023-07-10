package com.tawny.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.spring.test.mybatis.domain.Real_estate;
import com.tawny.spring.test.mybatis.repository.Real_estateRepository;

@Service
public class Real_estateService {
	
	@Autowired
	private Real_estateRepository real_estateRepository;
	
	// 1.
	// 전달된 id와 일치하는 매물 정보 얻기
	public Real_estate getReal_estate(int id) {
		Real_estate real_estate = real_estateRepository.selectReal_estate(id);
		return real_estate;
	}
	
	
	// 2.
	// 전달된 rentPrice와 일치하는 매물 정보 얻기
	public List<Real_estate> getReal_estateRentPrice(int rentPrice) {
		List<Real_estate> real_estateRentPrice = real_estateRepository.selectReal_estateRentPrice(rentPrice);
		return real_estateRentPrice;
	}
	
	
	// 3.
	// 전달된 area, price와 일치하는 매물 정보 얻기
	public List<Real_estate> getReal_estaetAreaPrice(int area, int price) {
		List<Real_estate> real_estateAreaPrice = real_estateRepository.selectReal_estateAreaPrice(area, price);
		return real_estateAreaPrice;			
	}


	
	
	
}
