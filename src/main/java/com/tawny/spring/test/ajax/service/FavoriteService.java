package com.tawny.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.spring.test.ajax.domain.Favorite;
import com.tawny.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public List<Favorite> getFavorite(){
		List<Favorite> favorite	= favoriteRepository.selectFavorite();
		return favorite;
	}
	
	public int addFavorite(
		String name
		, String address) {
		int count = favoriteRepository.insertFavorite(name, address);
		return count;
	}
	
	
	// 이메일 주소 중복확인
	public boolean duplicationEmail(String address) {
		int count = favoriteRepository.selectEmail(address);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
		
	}
}
