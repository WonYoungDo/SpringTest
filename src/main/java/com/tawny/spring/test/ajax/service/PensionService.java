package com.tawny.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.spring.test.ajax.domain.Pension;
import com.tawny.spring.test.ajax.repository.PensionRepository;

@Service
public class PensionService {
	
	@Autowired
	private PensionRepository pensionRepository;
	
	public List<Pension> getBooking() {
		List<Pension> bookingList = pensionRepository.selectbooking();
		return bookingList;
	}
}
