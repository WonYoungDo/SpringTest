package com.tawny.spring.test.ajax.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tawny.spring.test.ajax.domain.Pension;

@Repository
public interface PensionRepository {
	
	// 모든 예약자 정보를 가져오기
	public List<Pension> selectbooking();
	
	
}
