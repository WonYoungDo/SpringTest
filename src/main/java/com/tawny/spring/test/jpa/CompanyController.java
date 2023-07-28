package com.tawny.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tawny.spring.test.jpa.domain.Company;
import com.tawny.spring.test.jpa.service.CompanyService;

@RequestMapping("/lombok")
@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	
	// insert
	@ResponseBody
	@GetMapping("/add")
	public List<Company> createCompany() {
		
		List<Company> companyList = new ArrayList<>();
		
		Company company = companyService.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
		companyList.add(company);
		
		company = companyService.addCompany("버블팡", "여신 금융업", "대기업", 6834);
		companyList.add(company);
		
		return companyList;	
	}
	
	
	// update
	@ResponseBody
	@GetMapping("/update")
	public Company updateCompany() {
		Company company = companyService.updateCompany(8, "중소기업", 34);
		
		return company;
	}
	
	
	// delete
	@ResponseBody
	@GetMapping("/delete")
	public String deleteCompany() {
		companyService.deleteCompany(10);
		return "수행완료";
	}
	
}
