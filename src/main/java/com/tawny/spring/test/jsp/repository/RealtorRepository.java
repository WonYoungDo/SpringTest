package com.tawny.spring.test.jsp.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtorRepository {
	
	// insert한 쿼리 얻어오기
	public int insertRealtor(
			@Param("office") String office
			, @Param("phoneNumber") String phoneNumber
			, @Param("address") String address
			, @Param("grade") String grade);
	
	
// 	public int insertRealtor(Realtor realtor);
	
}
