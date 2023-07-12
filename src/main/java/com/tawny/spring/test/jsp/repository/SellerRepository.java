package com.tawny.spring.test.jsp.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository {
	public int insertSeller(
			@Param("id") int id
			, @Param("nicename") String nickname
			, @Param("profileImage") String profileImage
			, @Param("temperature") double temperature);
}