package com.tawny.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.spring.test.database.domain.Store;
import com.tawny.spring.test.database.repository.StoreRepository;



@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	// store 리스트 조회
	public List<Store> getStoreList() {
		List<Store> storeList = storeRepository.selectStoreList();
		return storeList;
	}
}
