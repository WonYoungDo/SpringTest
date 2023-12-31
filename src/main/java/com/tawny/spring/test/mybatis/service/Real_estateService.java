package com.tawny.spring.test.mybatis.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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

	
	
	
	// insert 다루기
//	public int addReal_estate(
//			@Param("realtorId") int realtorId
//			, @Param("address") String address
//			, @Param("area") int area
//			, @Param("type") String type
//			, @Param("price") int price) {
//		int count = real_estateRepository.insertReal_estate(realtorId, address, area, type, price);
//		return count;
//	}
	
	
	public int addRealEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice) {
		int count = real_estateRepository.insertRealEstate(realtorId, address, area, type, price, rentPrice);
		return count;
	}


	
//	public int addRealEstate(Real_estate real_estate, @Param("realtorId") int realtorId) {
//		int count = real_estateRepository.insertRealEstate(real_estate, realtorId);
//		return count;
//	}
	
	
	public int updateRealEstate(int id, String type, int price) {
		int count = real_estateRepository.updateRealEstate(id, type, price);
		return count;
	}
	
	
}
