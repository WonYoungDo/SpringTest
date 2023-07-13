package com.tawny.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tawny.spring.test.jsp.domain.Realtor;
import com.tawny.spring.test.jsp.service.RealtorService;

@Controller
@RequestMapping("/jsp/realtor")
public class RealtorController {
	
	@Autowired
	private RealtorService realtorService;
	
	
	@GetMapping("/realtor")
	public String creatRealtor(
			@RequestParam("office") String office
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("address") String address
			, @RequestParam("grade") String grade
			, Model model) {
		
		Realtor realtor = new Realtor();
		realtor.setOffice(office);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		int count = realtorService.addRealtor(realtor);
		
		// 앞에 문자열로 저장된 "realtor"로 realtor객체를 다룬다
		model.addAttribute("realtor", realtor);
		
		return "jsp/realtorInfo";
	}
	
	
	// jsp input 화면 불러오기
	@GetMapping("/input")
	public String realtorInput() {
		return "jsp/realtorInput";
	}
	
	
	
	

}
