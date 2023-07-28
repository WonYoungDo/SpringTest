package com.tawny.spring.test.jps.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.spring.test.jps.domain.Company;
import com.tawny.spring.test.jps.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public Company addCompany(
			String name
			, String business
			, String scale
			, int headcount) {
		
		Company company = Company.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build();
		company = companyRepository.save(company);
		
		return company;
	}
}
