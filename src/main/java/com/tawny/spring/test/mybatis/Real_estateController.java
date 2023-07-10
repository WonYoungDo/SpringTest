package com.tawny.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import com.tawny.spring.test.mybatis.domain.Real_estate;
import com.tawny.spring.test.mybatis.service.Real_estateService;

@Controller
@RequestMapping("/mybatis/realestate")
public class Real_estateController {
	
	@Autowired
	private Real_estateService real_estateService;
	
	// id를 전달받고, 해당 매물 정보를 json으로 response에 담는다.
	@RequestMapping("/1")
	@ResponseBody
	public Real_estate real_estate(@RequestParam("id") int id) { 
		// request로 얻어올 값을 id라는 이름으로 보여준다. 그리고 param로 얻어온 값을 int id 변수를 만들어 저장해준다
		Real_estate real_estate = real_estateService.getReal_estate(id);
		return real_estate;
	}
	
	
	// 월세를 전달받고 해당 월세보다 낮은 월게 매물을 json으로 response에 담는다.
	@RequestMapping("/2")
	@ResponseBody
	public List<Real_estate> real_estateRentPrice(@RequestParam("rent") int rentPrice) {
		List<Real_estate> real_estateRentPrice = real_estateService.getReal_estateRentPrice(rentPrice);
		return real_estateRentPrice;
	}
	
	
	// 가격과 넓이를 전달받고 해당 매물을 json으로 response에 담는다.
	@RequestMapping("/3")
	@ResponseBody
	public List<Real_estate> real_estateAreaPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		List<Real_estate> real_estateAreaPrice = real_estateService.getReal_estaetAreaPrice(area, price);
		return real_estateAreaPrice;
	}
}









