package com.tawny.spring.test.jsp.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.spring.test.jsp.domain.Seller;
import com.tawny.spring.test.jsp.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public int addSeller(
			@Param("nickname") String nickname
			, @Param("profileImage") String profileImage
			, @Param("temperature") double temperature) {
		int count = sellerRepository.insertSeller(nickname, profileImage, temperature);
		return count;
	}
	
	
	public Seller getSellerInfo() {
		Seller seller = sellerRepository.selectSeller();
		return seller;
	}
	
	public Seller getSeller(@Param("id") int id) {
		Seller seller = sellerRepository.selectSellerInfo(id);
		return seller;
	}
	

	
	
	
}
