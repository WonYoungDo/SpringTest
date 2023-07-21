package com.tawny.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tawny.spring.test.ajax.domain.Favorite;

@Repository
public interface FavoriteRepository {
	
	// 쿼리 조회
	public List<Favorite> selectFavorite();
	
	public int insertFavorite(
			@Param("name") String name
			, @Param("address") String address);

	public int selectEmail(@Param("address") String address);

}
