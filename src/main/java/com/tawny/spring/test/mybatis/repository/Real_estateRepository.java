package com.tawny.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tawny.spring.test.mybatis.domain.Real_estate;

@Repository
public interface Real_estateRepository {
	
	// 1. 전달된 id를 조건으로 얻어오기
	public Real_estate selectReal_estate(@Param("id") int id);
	// int id 값을 xml param "id"란 이름으로 사용한다
	
	// 2. 전달된 rentPrice를 조건으로 얻어오기
	// rentPrice보다 낮은 매물 행 정보 조회
	// 여러 행은 list
	public List<Real_estate> selectReal_estateRentPrice(@Param("rentPrice") int rentPrice);
	
	
	// 3. 전달된 area와 price를 조건으로 얻어오기
	public List<Real_estate> selectReal_estateAreaPrice(
			@Param("area") int area
			, @Param("price") int price);
	
	
	
	// insert 다루기 
	
	
	public int insertReal_estate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price);
		
	
	
	public int insertRealEstate(Real_estate real_estate, @Param("realtorId") int realtorId);
	
	
}
