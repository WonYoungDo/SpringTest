package com.tawny.spring.test.jpa.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.spring.test.jpa.domain.Company;
import com.tawny.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
//	@Autowired
//	private RecruitRepository recruitRepository;
	
	
	// insert
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
	
	
	// update
	public Company updateCompany(int id, String scale, int headcount) {
		
		Optional<Company> optionalCompany =  companyRepository.findById(id);
		Company company = optionalCompany.orElse(null);
		
		if(company != null) {
			company = company.toBuilder()
					.headcount(headcount)
					.scale(scale)
					.build();
					
			company = companyRepository.save(company);
		}
		return company;
	}


	// delete
	public void deleteCompany(int id) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		optionalCompany.ifPresent(company -> companyRepository.delete(company));
	}

	
	// select id로 조회
	
	
	// parameter 조건 조회
	
	
	// 복합 조건 조회 1
	
	
	// 복합 조건 조회 2
	
	
	// 정렬 제한 조건 
//	public List<Recruit> findTop3ByTypeOrderBySalaryDesc {
//		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
//	}
	
	// 범위 조회
	
	
	// native query 

}
