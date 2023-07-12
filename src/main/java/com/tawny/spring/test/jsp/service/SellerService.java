package com.tawny.spring.test.jsp.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.spring.test.jsp.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository selleRepository;
	
	public int addSeller(
			@Param("nicename") String nickname
			, @Param("profileImage") String profileImage
			, @Param("temperature") double temperature) {
		int count = selleRepository.insertSeller(nickname, profileImage, temperature);
		return count;
	}
}
