package com.tawny.spring.test.jps;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tawny.spring.test.jps.domain.Company;
import com.tawny.spring.test.jps.service.CompanyService;

@RequestMapping("/lombok")
@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
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
}
