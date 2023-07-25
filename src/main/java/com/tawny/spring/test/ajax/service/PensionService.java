package com.tawny.spring.test.ajax.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.spring.test.ajax.domain.Pension;
import com.tawny.spring.test.ajax.repository.PensionRepository;

@Service
public class PensionService {
	
	@Autowired
	private PensionRepository pensionRepository;
	
	
	// 예약자 목록 리스트
	public List<Pension> getBooking() {
		List<Pension> bookingList = pensionRepository.selectBooking();
		return bookingList;
	}
	
	
	// 예약자 추가 
	public int addBooking(
			String name
			, int headcount
			, int day
			, Date date
			, String phoneNumber
			, String state) {
		int count = pensionRepository.insertBooking(name, headcount, day, date, phoneNumber, state);
		return count;
	}
	
	
	// id를 입력 받아 삭제 버튼 활성화
	public int deleteBooking(int id) {
		int count = pensionRepository.deleteBooking(id);
		return count;
	}


}
