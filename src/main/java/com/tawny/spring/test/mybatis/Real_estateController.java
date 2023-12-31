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
	
	
	
	
	// insert 다루기
	
//	@RequestMapping("/test02/1")
//	@ResponseBody
//	public String creatReal_estate() {
//		int count = real_estateService.addReal_estate(3, "푸르지용 리버 303동 1104호", 89, "매매", 100000);
//		return "입력 성공" + count;
//	}
	
	
	@RequestMapping("/test02/2")
	@ResponseBody
	public String creatRealEstate(@RequestParam("realtorId") int realtorId) {
		int count = real_estateService.addRealEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력 성공" + count;
	}
	
	
	
//	@ResponseBody
//	@RequestMapping("/test02/2")
//	public String creatRealEstate(@RequestParam("realtorId") int realtorId) {
//		Real_estate real_estate = new Real_estate();
//		real_estate.setAddress("썅떼빌리버 오피스텔 814호");
//		real_estate.setArea(45);
//		real_estate.setType("월세");
//		real_estate.setPrice(100000);
//		real_estate.setRentPrice(120);
//		
//		int count = real_estateService.addRealEstate(real_estate, realtorId);
//		return "입력 성공 " + count;
//	}
	
	@ResponseBody
	@RequestMapping("/test02/3")
	public String updateRealEstate() {
		int count = real_estateService.updateRealEstate(22, "전세", 70000);
		return "수정 성공 : " + count;
	}
	
	
	
	
}









