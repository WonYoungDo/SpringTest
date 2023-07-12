package com.tawny.spring.test.jsp.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tawny.spring.test.jsp.domain.Seller;

@Repository
public interface SellerRepository {

	public int insertSeller(
			@Param("nickname") String nickname
			, @Param("profileImage") String profileImage
			, @Param("temperature") double temperature);

	
	public Seller selectSeller();
	
	
	public Seller selectSellerInfo(@Param("id") int id);
}
