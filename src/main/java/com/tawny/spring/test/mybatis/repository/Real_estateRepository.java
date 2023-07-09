package com.tawny.spring.test.mybatis.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tawny.spring.test.mybatis.domain.Real_estate;

@Repository
public interface Real_estateRepository {
	
	// 1번 id를 조건으로 얻어오기
	public Real_estate selectReal_estate(@Param("id") int id);
	
	
	
}
