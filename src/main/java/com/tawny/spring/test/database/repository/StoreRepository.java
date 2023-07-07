package com.tawny.spring.test.database.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tawny.spring.test.database.domain.Store;


@Repository
public interface StoreRepository {
	
	// 여러 행의 정보는 list로 조회
	// 해당하는 컬럼과 이름이 정확히 일치하는 맴버 변수 domain에서 생성
	public List<Store> selectStoreList();
}
