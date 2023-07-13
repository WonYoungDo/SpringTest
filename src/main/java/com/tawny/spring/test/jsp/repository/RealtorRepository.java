package com.tawny.spring.test.jsp.repository;

import org.springframework.stereotype.Repository;

import com.tawny.spring.test.jsp.domain.Realtor;

@Repository
public interface RealtorRepository {
	
	// insert한 쿼리 얻어오기
	// insert는 실행될 행의 갯수에 영향을 받는다
//	public int insertRealtor( 
//			@Param("office") String office
//			, @Param("phoneNumber") String phoneNumber
//			, @Param("address") String address
//			, @Param("grade") String grade);
//	
	
 	public int insertRealtor(Realtor realtor);

	
}
