package com.tawny.spring.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tawny.spring.test.mybatis.domain.Real_estate;
import com.tawny.spring.test.mybatis.service.Real_estateService;

@Controller
@RequestMapping("/mybatis/realestate")
public class Real_estateController {
	
	@Autowired
	private Real_estateService real_estateService;
	
	@RequestMapping("/1")
	@ResponseBody
	public Real_estate real_estate(@RequestParam("id") int id) {
		Real_estate real_estate = real_estateService.getReal_estate(id);
		return real_estate;
	}
	
	
	@Autowired
	private Real_estateService real_estateServiceRentPrice;
	
	@RequestMapping("/2")
	@ResponseBody
	public Real_estate real_estateRentPrice(@RequestParam("rentPrice") int rentPrice);
		Real_estate real_estateRentPrice = real_estateServiceRentPrice.getReal_estate(rentPrice);
		return real_estateRentPrice;
}
