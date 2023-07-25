package com.tawny.spring.test.ajax.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tawny.spring.test.ajax.domain.Pension;

@Repository
public interface PensionRepository {
	
	// 모든 예약자 정보를 가져오기 -> 예약 목록 화면
	public List<Pension> selectBooking();
	
	// 예약하기로 추가된 예약자 -> 예약하기 화면 -> 예약 목록에 주가
	public int insertBooking(
			@Param("name") String name
			, @Param("headcount") int headcount
			, @Param("day") int day
			, @Param("date") Date date
			, @Param("phoneNumber") String phoneNumber
			, @Param("state") String state);

	// 삭제 버튼 클릭 시 해당 행 삭제
	public int deleteBooking(@Param("id") int id);
}
